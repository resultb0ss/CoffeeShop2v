package com.example.coffeeshop2v.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeshop2v.Model.ItemsModel
import com.example.coffeeshop2v.databinding.ViewholderItemBinding

class ListItemAdapter(val items: MutableList<ItemsModel>, val onClick: (ItemsModel) -> Unit) :
    RecyclerView.Adapter<ListItemAdapter.ItemsViewHolder>() {

    private var context: Context? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemsViewHolder {
        context = parent.context
        val binding = ViewholderItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ItemsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemsViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.binding.viewHolderItemTitleTextView.text = item.title
        holder.binding.viewHolderItemPriceTextView.text = "$${item.price}"
        holder.binding.viewHolderItemSubtitleTextView.text = item.extra

        Glide.with(holder.itemView.context).load(item.picUrl)
            .into(holder.binding.viewHolderItemImage)

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int = items.size


    class ItemsViewHolder(val binding: ViewholderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}