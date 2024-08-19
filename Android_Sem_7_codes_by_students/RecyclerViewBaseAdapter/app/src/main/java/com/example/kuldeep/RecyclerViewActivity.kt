package com.example.kuldeep

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var arrayList: ArrayList<DataModel>
    lateinit var recyclerView: RecyclerView
    var recyclerAdapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // code goes here
        arrayList = ArrayList<DataModel>()
        // insert data in list
        arrayList.add(DataModel("Version1", "10.0"))
        arrayList.add(DataModel("Version2", "11.0"))
        arrayList.add(DataModel("Version3", "12.0"))
        arrayList.add(DataModel("Version4", "13.0"))
        arrayList.add(DataModel("Version5", "14.0"))
        arrayList.add(DataModel("Version6", "15.0"))
        arrayList.add(DataModel("Version7", "16.0"))
        arrayList.add(DataModel("Version1", "10.0"))
        arrayList.add(DataModel("Version2", "11.0"))
        arrayList.add(DataModel("Version3", "12.0"))
        arrayList.add(DataModel("Version4", "13.0"))
        arrayList.add(DataModel("Version5", "14.0"))
        arrayList.add(DataModel("Version6", "15.0"))
        arrayList.add(DataModel("Version7", "16.0"))
        arrayList.add(DataModel("Version1", "10.0"))
        arrayList.add(DataModel("Version2", "11.0"))
        arrayList.add(DataModel("Version3", "12.0"))
        arrayList.add(DataModel("Version4", "13.0"))
        arrayList.add(DataModel("Version5", "14.0"))
        arrayList.add(DataModel("Version6", "15.0"))
        arrayList.add(DataModel("Version7", "16.0"))

        // adapter
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.adapter = RecyclerAdapter(this, arrayList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
    }
}