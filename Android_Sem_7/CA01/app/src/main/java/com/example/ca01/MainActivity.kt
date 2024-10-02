package com.example.ca01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val itemList = listOf(
            Item(R.drawable.sample_image_1, "Description for item 1"),
            Item(R.drawable.sample_image_1, "Description for item 1"),
            Item(R.drawable.sample_image_1, "Description for item 1"),
            Item(R.drawable.sample_image_1, "Description for item 1"),
            Item(R.drawable.sample_image_1, "Description for item 1"),
            Item(R.drawable.sample_image_2, "Description for item 2"),
            Item(R.drawable.sample_image_2, "Description for item 2"),
            Item(R.drawable.sample_image_2, "Description for item 2"),
            Item(R.drawable.sample_image_2, "Description for item 2"),
            Item(R.drawable.sample_image_2, "Description for item 2"),
            Item(R.drawable.sample_image_3, "Description for item 3"),
            Item(R.drawable.sample_image_3, "Description for item 3"),
            Item(R.drawable.sample_image_3, "Description for item 3"),
            Item(R.drawable.sample_image_3, "Description for item 3"),
            Item(R.drawable.sample_image_3, "Description for item 3")
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(itemList)
    }
}