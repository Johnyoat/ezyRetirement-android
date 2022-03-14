package com.ezyretirement.app.views.stimulation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ezyretirement.app.adapters.RetirementStageListAdapter
import com.ezyretirement.app.databinding.StimulationFragmentBinding
import com.ezyretirement.app.ext.replaceFragmentWith
import com.ezyretirement.app.models.PersonalData
import com.ezyretirement.app.viewModels.UserDataViewModel
import com.ezyretirement.app.views.profile.ProfileFragment
import com.google.android.material.transition.MaterialFadeThrough

class StimulationFragment(private val personalData: PersonalData) : Fragment() {

    private val viewModel by viewModels<UserDataViewModel>()
    private lateinit var binding: StimulationFragmentBinding
    private var retirementAge = personalData.yearsToRetirement


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StimulationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setRetirementText()


            binding.userName.text = personalData.name
            binding.retirementAge.text = personalData.yearsToRetirement.toString()
            binding.currentRetirementNest.text = "$${personalData.currentRetirementNest}"

            binding.yearlyContribution.text = if (personalData.isContributionRate){
                "${personalData.yearlyContribution} %"
            }else{
                "$${personalData.yearlyContribution}"
            }


        binding.retirementStageList.apply {
            adapter = RetirementStageListAdapter(personalData.retirementStages,requireContext())
        }



        binding.userProfile.setOnClickListener {
            replaceFragmentWith(ProfileFragment())
        }

        binding.plus.setOnClickListener {
            increaseRetirementYear()
        }


        binding.minus.setOnClickListener {
            decreaseRetirementYear()
        }

    }


    private fun increaseRetirementYear() {
        retirementAge++
        setRetirementText()
    }


    private fun decreaseRetirementYear() {
        retirementAge--
        setRetirementText()
    }


    private fun setRetirementText() {
        "$retirementAge Years old".also { binding.retirementAge.text = it }
    }

}