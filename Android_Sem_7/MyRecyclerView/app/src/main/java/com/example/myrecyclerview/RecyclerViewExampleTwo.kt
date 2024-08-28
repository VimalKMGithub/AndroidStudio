package com.example.myrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewExampleTwo : AppCompatActivity() {
    lateinit var arrayList: ArrayList<GridPojo>
    lateinit var recyclerView: RecyclerView
    var adapterRecycler: AdapterRecyclerTwo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example_two)
        gridListData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewLinear)
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.setLayoutManager(gridLayoutManager)
        adapterRecycler = AdapterRecyclerTwo(this, arrayList)
        recyclerView.setAdapter(adapterRecycler)
    }

    private fun gridListData() {
        arrayList = ArrayList()
        arrayList.add(GridPojo("Mobile", R.drawable.ic_launcher_background))
        arrayList.add(GridPojo("Internet", R.drawable.ic_launcher_background))
        arrayList.add(GridPojo("Wifi", R.drawable.ic_launcher_background))
        arrayList.add(GridPojo("Database", R.drawable.ic_launcher_background))
        arrayList.add(GridPojo("Battery", R.drawable.ic_launcher_background))
        arrayList.add(GridPojo("Alarm", R.drawable.ic_launcher_background))
        arrayList.add(GridPojo("Signal", R.drawable.ic_launcher_background))
        arrayList.add(GridPojo("Bluetooth", R.drawable.ic_launcher_background))
        arrayList.add(GridPojo("Aeroplane", R.drawable.ic_launcher_background))
    }
}