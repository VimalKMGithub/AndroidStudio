package com.example.a02customlistviewbaseadapter

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CustomListViewBaseAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view_base_adapter)

        val listView = findViewById<ListView>(R.id.listView)
        val list = mutableListOf<Model>()

        list.add(Model(R.drawable.user1, "Akanksha Sharma", "6857491230"))
        list.add(Model(R.drawable.user2, "Aakriti Saxena", "6123456789"))
        list.add(Model(R.drawable.user3, "Shraddha Gupta", "6513578642"))
        list.add(Model(R.drawable.user4, "Rashi Roy", "9513578642"))
        list.add(Model(R.drawable.user5, "Subham Ray", "8529674130"))
        list.add(Model(R.drawable.user6, "Chaitanya Krishna", "8529674130"))
        list.add(Model(R.drawable.user3, "Shraddha Gupta", "6513578642"))
        list.add(Model(R.drawable.user2, "Aakriti Saxena", "6123456789"))
        list.add(Model(R.drawable.user6, "Chaitanya Krishna", "8529674130"))
        list.add(Model(R.drawable.user4, "Rashi Roy", "9513578642"))
        list.add(Model(R.drawable.user1, "Akanksha Sharma", "6857491230"))
        list.add(Model(R.drawable.user5, "Subham Ray", "8529674130"))

        listView.adapter = MyBaseAdapter(this, list);
    }
}