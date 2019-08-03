package com.yashovardhan99.recyclerviewsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.yashovardhan99.recyclerviewsample.databinding.FragmentItemDetailBinding

/**
 * Created by Yashovardhan99 on 1/7/19 as a part of RecyclerViewDemo.
 */
class ItemDetailFragment : Fragment() {
    private lateinit var binding: FragmentItemDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_detail, container, false)
        val args: ItemDetailFragmentArgs by navArgs()
        binding.item = args.item
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = transition
        sharedElementReturnTransition = transition
    }
}