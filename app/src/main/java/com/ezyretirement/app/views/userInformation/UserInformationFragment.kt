package com.ezyretirement.app.views.userInformation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.transition.TransitionManager
import com.ezyretirement.app.R
import com.ezyretirement.app.databinding.ActivityUserInformationBinding
import com.ezyretirement.app.ext.*
import com.ezyretirement.app.models.PersonalData
import com.ezyretirement.app.viewModels.UserDataViewModel
import com.ezyretirement.app.views.stimulation.StimulationFragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis

class UserInformationFragment : Fragment() {
    private lateinit var binding: ActivityUserInformationBinding
    private val sharedAxis = MaterialSharedAxis(MaterialSharedAxis.X, true)
    private var step = 0
    private val personData = PersonalData()
    private val userDataViewModel by viewModels<UserDataViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ActivityUserInformationBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf("Snow Bird", "Other One")
        val adapter = ArrayAdapter(requireContext(), R.layout.scenario_list_item, items)
        step = 0

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .build()

        datePicker.addOnPositiveButtonClickListener { dob ->
            val date = dob + 86400000
            binding.dob.editText?.setText(date.toDateString())
            personData.dob = date
        }

//        checkInputTexts(
//            binding.name,
//            binding.dob,
//            binding.currentSalary,
//            binding.occupation,
//            binding.scenario,
//            binding.yearsToRetirement,
//            binding.yearlyContribution,
//            binding.desiredActiveRetirementSalary
//        )

        (binding.scenario.editText as AutoCompleteTextView).setAdapter(adapter)

        binding.nextBtn.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.userInfoContainer, sharedAxis)
            binding.backBtn.text = getString(R.string.previous)
            when (step) {
                0 -> {
                    verifyUserDetails()
                }

                1 -> {
                    verifyRetirementDetails()
                }

                2 -> {
                    computeRetirementPolicy()
                }
            }
        }

        binding.backBtn.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.userInfoContainer, sharedAxis)
            when (step) {
                0 -> {
                    requireActivity().finish()
                }

                1 -> {
                    binding.userInformation.visibility = View.VISIBLE
                    binding.userRetirementInfo.visibility = View.GONE
                    binding.backBtn.text = getString(R.string.close)
                    step--
                }

                2 -> {
                    binding.userRetirementInfo.visibility = View.VISIBLE
                    binding.userRetirement.visibility = View.GONE
                    binding.backBtn.text = getString(R.string.previous)
                    step--
                }
            }
        }


        val dob = view.findViewById<TextInputEditText>(R.id.dobEdit)
        dob.setOnClickListener {
            datePicker.show(childFragmentManager, "dob")
        }


    }


    private fun verifyUserDetails() {
        if (isInputsValid(binding.name, binding.dob, binding.currentSalary, binding.occupation)) {
            personData.name = binding.name.text()
            personData.occupation = binding.occupation.text()
            personData.currentSalary = binding.currentSalary.text().toDouble()

            binding.userRetirementInfo.visibility = View.VISIBLE
            binding.userInformation.visibility = View.GONE
            step++
        }
    }


    private fun verifyRetirementDetails() {

        if (isInputsValid(
                binding.scenario,
                binding.yearsToRetirement,
                binding.yearlyContribution,
                binding.desiredActiveRetirementSalary
            )
        ) {
            personData.scenario = binding.scenario.text()
            personData.yearsToRetirement = binding.yearsToRetirement.text().toInt()
            personData.yearlyContribution = binding.yearlyContribution.text().toDouble()


            binding.userRetirement.visibility = View.VISIBLE
            binding.userRetirementInfo.visibility = View.GONE
            step++
        }


    }


    private fun computeRetirementPolicy() {
        replaceFragmentWith(StimulationFragment(personData))
    }
}