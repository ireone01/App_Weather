package com.example.homework2.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter: RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
       val view =  LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind("page $position")
    }


    class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(android.R.id.text1)
        fun bind(text:String){
            textView.text = text
        }
    }
}