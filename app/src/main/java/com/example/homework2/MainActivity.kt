package com.example.homework2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.homework2.Fragment.ViewPagerAdapter


class MainActivity :AppCompatActivity(){
    private val API_KEY = "SC8yMrpOtTb4IJA2MFxXHzlvrVMAxcNy"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =RecyclerViewAdapter()
          }
}