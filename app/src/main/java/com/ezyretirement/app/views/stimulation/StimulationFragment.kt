package com.ezyretirement.app.views.stimulation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ezyretirement.app.R

class StimulationFragment : Fragment() {

    private val viewModel by viewModels<StimulationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stimulation_fragment, container, false)
    }

}