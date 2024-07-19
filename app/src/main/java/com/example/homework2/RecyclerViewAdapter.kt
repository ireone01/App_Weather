package com.example.homework2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.homework2.Fragment.PageFragment1
import com.example.homework2.Fragment.PageFragment2
import com.example.homework2.Fragment.ViewPagerAdapter

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val VIEW_TYPE_VIEWPAGER = 0
        const val VIEW_TYPE_FRAGMENT = 1
        const val LOG = "RecyclerViewAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_VIEWPAGER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager, parent, false)
                Log.i(LOG, "onCreateViewHolder VIEW_TYPE_VIEWPAGER")
                ViewPagerViewHolder(view)
            }
            VIEW_TYPE_FRAGMENT -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fragment_container, parent, false)
                Log.i(LOG, "onCreateViewHolder VIEW_TYPE_FRAGMENT")
                FragmentViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type encountered")
        }
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewPagerViewHolder -> {
                holder.bind()
            }
            is FragmentViewHolder -> {
                holder.bind(position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_VIEWPAGER
            else -> VIEW_TYPE_FRAGMENT
        }
    }
}

class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val viewPager: ViewPager2 = itemView.findViewById(R.id.viewPager)

    fun bind() {
        val viewPagerAdapter = ViewPagerAdapter()
        viewPager.adapter = viewPagerAdapter
        Log.i("ViewPagerViewHolder", "bind VIEW_TYPE_VIEWPAGER")
    }
}

class FragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val fragmentContainer: FrameLayout = itemView.findViewById(R.id.fragment_container)

    fun bind(position: Int) {
        val fragment = when (position) {
            1 -> PageFragment1()
            2 -> PageFragment2()
            else -> throw IllegalArgumentException("FragmentViewHolder bind method received invalid position")
        }
        (itemView.context as FragmentActivity).supportFragmentManager
            .beginTransaction()
            .replace(fragmentContainer.id, fragment)
            .commit()
        Log.i("FragmentViewHolder", "bind VIEW_TYPE_FRAGMENT, position: $position")
    }
}
