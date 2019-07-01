package com.yashovardhan99.recyclerviewsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.yashovardhan99.recyclerviewsample.databinding.FragmentItemDetailBinding

/**
 * Created by Yashovardhan99 on 1/7/19 as a part of RecyclerViewDemo.
 */
class ItemDetailFragment : Fragment() {
    private lateinit var binding: FragmentItemDetailBinding
    private lateinit var item: ListItem

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_detail, container, false)
        val args: ItemDetailFragmentArgs by navArgs()
        binding.item = args.item
        return binding.root
    }
}