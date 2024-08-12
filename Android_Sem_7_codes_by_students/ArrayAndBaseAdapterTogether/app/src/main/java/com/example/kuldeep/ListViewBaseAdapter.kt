package com.example.kuldeep

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewBaseAdapter : AppCompatActivity() {
    // initialize variables
    var adapter: BaseAdapter? = null
    var list: ArrayList<BaseDataModel> = ArrayList()
    lateinit var listview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_base_adapter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listview = findViewById(R.id.listview)
        listview.adapter = BaseAdapter(this, list)

        list.add(BaseDataModel(R.drawable.user1, "Akanksha Sharma", "6857491230"))
        list.add(BaseDataModel(R.drawable.user2, "Aakriti Saxena", "6123456789"))
        list.add(BaseDataModel(R.drawable.user3, "Shraddha Gupta", "6513578642"))
        list.add(BaseDataModel(R.drawable.user4, "Rashi Roy", "9513578642"))
        list.add(BaseDataModel(R.drawable.user5, "Subham Ray", "8529674130"))
        list.add(BaseDataModel(R.drawable.user6, "Chaitanya Krishna", "8529674130"))

        var btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            startActivity(Intent(this, ListViewArrayAdapter::class.java))
        }
    }
}