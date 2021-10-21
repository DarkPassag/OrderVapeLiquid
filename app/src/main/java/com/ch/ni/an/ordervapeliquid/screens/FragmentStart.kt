package com.ch.ni.an.ordervapeliquid.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ch.ni.an.ordervapeliquid.viewModel.OrderViewModel

class FragmentStart: Fragment() {
    private val myModel: OrderViewModel by activityViewModels()

}