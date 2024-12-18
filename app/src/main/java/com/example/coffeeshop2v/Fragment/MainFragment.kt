package com.example.coffeeshop2v.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop2v.databinding.FragmentMainBinding
import eightbitlab.com.blurview.RenderScriptBlur
import android.R

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun onResume() {
        super.onResume()
        setBlurEffect()
        setVariable()
    }

    private fun setVariable(){
        binging.apply {
            mainFragmentButtonIceDrink.setOnClickListener{ toListFragment(2,"Ice Drink")}
            mainFragmentButtonHotDrink.setOnClickListener{ toListFragment(3,"Hot Drink")}
            mainFragmentButtonHotCoffee.setOnClickListener{ toListFragment(1,"Hot Coffee")}
            mainFragmentButtonIceCoffee.setOnClickListener{ toListFragment(4,"Ice Coffee")}
            mainFragmentButtonBrewingCoffee.setOnClickListener{ toListFragment(5,"Brewing Coffee")}
            mainFragmentButtonShake.setOnClickListener{ toListFragment(6,"Shake")}
            mainFragmentButtonRestaurant.setOnClickListener{ toListFragment(7,"Restaurant")}
            mainFragmentButtonBreakfast.setOnClickListener{ toListFragment(8,"Breakfast")}
            mainFragmentButtonCake.setOnClickListener{ toListFragment(9,"Cake")}
        }
    }

    private fun toListFragment(id: Int, title: String) {
        val action = MainFragmentDirections.Companion.actionMainFragmentToListFragment(id, title)
        findNavController().navigate(action)
    }

    private fun setBlurEffect(){
        val radius = 10f
        val decorView = requireActivity().window.decorView
        val rootView = decorView.findViewById<View>(R.id.content) as ViewGroup
        val windowBackGround = decorView.background
        binging.blurView.setupWith(
            rootView,
            RenderScriptBlur(requireContext())
        )
            .setFrameClearDrawable(windowBackGround)
            .setBlurRadius(radius)

        binging.blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
        binging.blurView.clipToOutline = true
    }


}