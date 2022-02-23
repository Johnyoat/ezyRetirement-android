package com.ezyretirement.app.views.personalData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ezyretirement.app.R
import com.ezyretirement.app.databinding.PersonalDataFragmentBinding
import com.google.android.material.transition.MaterialFadeThrough

class PersonalDataFragment : Fragment() {
    private val viewModel by viewModels<PersonalDataViewModel>()
    private lateinit var binding: PersonalDataFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PersonalDataFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title.text = getString(R.string.personal_data)
        binding.toolbar.title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        binding.toolbar.backBtn.setColorFilter(ContextCompat.getColor(requireContext(),R.color.white))


        binding.toolbar.backBtn.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

}