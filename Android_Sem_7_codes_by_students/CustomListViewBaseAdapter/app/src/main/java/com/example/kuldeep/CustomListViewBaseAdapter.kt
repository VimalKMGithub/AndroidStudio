package com.example.kuldeep

import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomListViewBaseAdapter : AppCompatActivity() {
    // initializing variables
    lateinit var listview : ListView
    var list: ArrayList<Model> = ArrayList()
    var adapter: BaseAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view_base_adapter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listview = findViewById(R.id.listview)
        listview.adapter = BaseAdapter(this, list)

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

        adapter?.notifyDataSetChanged()
    }
}