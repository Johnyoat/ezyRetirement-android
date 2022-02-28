package com.ezyretirement.app.views.stimulation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ezyretirement.app.R
import com.ezyretirement.app.databinding.StimulationFragmentBinding
import com.ezyretirement.app.ext.replaceFragmentWith
import com.ezyretirement.app.views.profile.ProfileFragment
import com.google.android.material.transition.MaterialFadeThrough

class StimulationFragment : Fragment() {

    private val viewModel by viewModels<StimulationViewModel>()
    private lateinit var binding:StimulationFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StimulationFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userProfile.setOnClickListener {
            replaceFragmentWith(ProfileFragment())
        }
    }

}