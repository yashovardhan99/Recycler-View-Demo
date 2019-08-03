package com.yashovardhan99.recyclerviewsample

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yashovardhan99.recyclerviewsample.databinding.LayoutItemBinding

/**
 * Created by Yashovardhan99 on 1/7/19 as a part of RecyclerViewDemo.
 */
class RecyclerAdapter(
    private val list: ArrayList<ListItem>,
    private val fragment: RecyclerFragment
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(private val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(fragment: RecyclerFragment, listItem: ListItem) {
            binding.item = listItem
            binding.root.setOnClickListener {
                Log.d("Adapter", "onClick : ${listItem.itemName}")
                RecyclerFragment.openDetails(fragment, listItem, binding.title, binding.description)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fragment, list[position])
    }
}