package com.example.coffeeshop2v.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.coffeeshop2v.databinding.FragmentBaseBinding


abstract class BaseFragment<T: ViewBinding> : Fragment() {

    private var _binding: T? = null
    protected val binging get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater,container)

        return binging.root
    }

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}