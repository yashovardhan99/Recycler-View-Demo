package com.yashovardhan99.recyclerviewsample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.VelocityTracker
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yashovardhan99.recyclerviewsample.databinding.FragmentRecyclerBinding

/**
 * Created by Yashovardhan99 on 1/7/19 as a part of RecyclerViewDemo.
 */
class RecyclerFragment : Fragment() {
    private lateinit var binding: FragmentRecyclerBinding
    private lateinit var list: ArrayList<ListItem>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_recycler, container, false)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        setList(100) //Creates a list of n items
        binding.recyclerView.adapter = RecyclerAdapter(list, this)

        //animating the recyclerList
        FlingAnimation(binding.recyclerView, DynamicAnimation.SCROLL_Y).apply {
            val vt = VelocityTracker.obtain()
            vt.computeCurrentVelocity(1000)
            setStartVelocity(vt.yVelocity)
            vt.recycle()
            setMinValue(0f)
            friction = 1.1f
            minimumVisibleChange = DynamicAnimation.MIN_VISIBLE_CHANGE_PIXELS
            start()
        }
        return binding.root
    }

    private fun setList(n: Int) {
        list = ArrayList(n)
        for (i in 1..n)
            list.add(ListItem("Item $i", "Item $i description"))
    }

    companion object Navigate {
        fun openDetails(fragment: RecyclerFragment, listItem: ListItem, title: TextView, description: TextView) {
            ViewCompat.setTransitionName(title, "Title")
            ViewCompat.setTransitionName(description, "Description")
            fragment.activity?.let {
                val extras = FragmentNavigatorExtras(
                    title to "Title",
                    description to "Description"
                )
                Log.d("RECYCLER NAVIGATE", extras.sharedElements.toString())
                Navigation.findNavController(it, R.id.nav_host_fragment).navigate(
                    RecyclerFragmentDirections.actionRecyclerFragmentToItemDetailFragment(listItem), extras
                )
            }
        }
    }
}