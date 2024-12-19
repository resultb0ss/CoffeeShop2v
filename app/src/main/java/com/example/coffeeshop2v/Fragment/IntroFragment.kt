package com.example.coffeeshop2v.Fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop2v.R
import com.example.coffeeshop2v.databinding.FragmentIntroBinding


class IntroFragment : BaseFragment<FragmentIntroBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentIntroBinding {

        return FragmentIntroBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("@@@", "OnView IntroFragment")
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_introFragment_to_mainFragment)
        }, 2000)

    }
}