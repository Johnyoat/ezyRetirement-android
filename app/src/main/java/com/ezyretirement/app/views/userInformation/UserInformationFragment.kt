package com.ezyretirement.app.views.userInformation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.ezyretirement.app.R
import com.ezyretirement.app.databinding.ActivityUserInformationBinding
import com.ezyretirement.app.ext.replaceFragmentWith
import com.ezyretirement.app.views.profile.ProfileFragment
import com.google.android.material.transition.MaterialFadeThrough

class UserInformationFragment : Fragment() {
    private lateinit var binding: ActivityUserInformationBinding
    private var step = 0


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


        binding.nextBtn.setOnClickListener {
           when (step) {
                0 -> {
                    binding.userInformation.isVisible = false
                    binding.userRetirement.isVisible = true
                    binding.backBtn.text = getString(R.string.previous)
                    step++
                }
                1 -> {
                    replaceFragmentWith(ProfileFragment())
                }
            }
        }

        binding.backBtn.setOnClickListener {
            when(step){
                0->{
                    requireActivity().finish()
                }

                1->{
                    binding.userInformation.isVisible = true
                    binding.userRetirement.isVisible = false
                    binding.backBtn.text = getString(R.string.close)
                    step--
                }
            }
        }


    }
}