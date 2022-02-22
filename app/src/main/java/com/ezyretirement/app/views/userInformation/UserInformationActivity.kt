package com.ezyretirement.app.views.userInformation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ezyretirement.app.databinding.ActivityUserInformationBinding
import com.google.android.material.transition.MaterialFadeThrough

class UserInformationActivity : Fragment() {
    private lateinit var binding: ActivityUserInformationBinding


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
}