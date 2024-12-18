package com.example.coffeeshop2v.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.coffeeshop2v.Model.ItemsModel
import com.example.coffeeshop2v.R
import com.example.coffeeshop2v.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private lateinit var item: ItemsModel

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bundle()
    }

    private fun bundle() {
        item = DetailFragmentArgs.Companion.fromBundle(requireArguments()).item
        binging.apply {
            detailFragmentTitleText.text = item.title
            detailFragmentSubtitleText.text = item.extra
            detailFragmentDescriptionText.text = item.description
            detailFragmentPriceText.text = "$" + item.price.toString()

            Glide.with(requireContext()).load(item.picUrl[0]).apply(
                RequestOptions.bitmapTransform(RoundedCorners(100))
            ).into(binging.detailFragmentMainImage)

            backButton.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_listFragment)
            }

            detailFragmentSizeButtonS.setOnClickListener {
                detailFragmentSizeButtonS.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.orange_stroke_bg)
                )
                detailFragmentSizeButtonM.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.dark_grey_bg2)
                )
                detailFragmentSizeButtonL.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.dark_grey_bg2)
                )
                detailFragmentSizeButtonS.setTextColor(resources.getColor(R.color.orange))
                detailFragmentSizeButtonM.setTextColor(resources.getColor(R.color.white))
                detailFragmentSizeButtonL.setTextColor(resources.getColor(R.color.white))
            }

            detailFragmentSizeButtonM.setOnClickListener {
                detailFragmentSizeButtonS.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.dark_grey_bg2)
                )
                detailFragmentSizeButtonM.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.orange_stroke_bg)
                )
                detailFragmentSizeButtonL.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.dark_grey_bg2)
                )
                detailFragmentSizeButtonS.setTextColor(resources.getColor(R.color.white))
                detailFragmentSizeButtonM.setTextColor(resources.getColor(R.color.orange))
                detailFragmentSizeButtonL.setTextColor(resources.getColor(R.color.white))
            }

            detailFragmentSizeButtonL.setOnClickListener {
                detailFragmentSizeButtonS.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.dark_grey_bg2)
                )
                detailFragmentSizeButtonM.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.dark_grey_bg2)
                )
                detailFragmentSizeButtonL.setBackgroundDrawable(
                    ContextCompat
                        .getDrawable(requireContext(), R.drawable.orange_stroke_bg)
                )
                detailFragmentSizeButtonS.setTextColor(resources.getColor(R.color.white))
                detailFragmentSizeButtonM.setTextColor(resources.getColor(R.color.white))
                detailFragmentSizeButtonL.setTextColor(resources.getColor(R.color.orange))
            }
        }
    }

}