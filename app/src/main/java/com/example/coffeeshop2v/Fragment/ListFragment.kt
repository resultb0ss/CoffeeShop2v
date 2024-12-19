package com.example.coffeeshop2v.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeshop2v.Adapter.ListItemAdapter
import com.example.coffeeshop2v.R
import com.example.coffeeshop2v.ViewModel.MainViewModel
import com.example.coffeeshop2v.databinding.FragmentListBinding


class ListFragment : BaseFragment<FragmentListBinding>() {

    private val viewModel = MainViewModel()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binging.menuButton.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment_to_mainFragment)
        }

        val id = ListFragmentArgs.Companion.fromBundle(requireArguments()).id
        val title = ListFragmentArgs.Companion.fromBundle(requireArguments()).title

        binging.listFragmentTitleText.text = title

        Log.d("@@@", "Id $id")
        when (id) {
            1 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_1))

            2 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_2))

            3 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_3))

            4 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_4))

            5 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_5))

            6 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_6))

            7 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_7))

            8 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_8))

            9 -> binging.listFragmentCategoryImage
                .setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_9))
        }

        binging.progressBar.visibility = View.VISIBLE
        viewModel.loadFiltered(id).observe(requireActivity()) { item ->
            if (item.isEmpty()) {
                Log.d("@@@", "Observer item empty $item")
                binging.emptyText.visibility = View.VISIBLE
            } else {
                Log.d("@@@", "Observer item not empty $item")
                binging.emptyText.visibility = View.GONE
                binging.listFragmentRecyclerView.layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
                binging.listFragmentRecyclerView.adapter = ListItemAdapter(item) { item ->
                    val action =
                        ListFragmentDirections.Companion.actionListFragmentToDetailFragment(
                            item,
                            id,
                            title
                        )
                    findNavController().navigate(action)
                }
                binging.progressBar.visibility = View.GONE
            }
        }

    }


}