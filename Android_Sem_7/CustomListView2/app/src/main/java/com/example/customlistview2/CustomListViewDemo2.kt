package com.example.customlistview2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CustomListViewDemo2 : AppCompatActivity() {
    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var add: Button

    @SuppressLint("MissingInflateId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view_demo2)
        var listView = findViewById<ListView>(R.id.listView)
        var list = mutableListOf<ModelDemo>()
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        add = findViewById(R.id.add)
        var ad = MyAdapterForCustomListViewDemo(this, R.layout.mycustomlookfile, list)
        listView.adapter = ad
        add.setOnClickListener {
            list.add(ModelDemo(et1.text.toString(), et2.text.toString(), R.drawable.fb))
            ad.notifyDataSetChanged()

        }
        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            if (position == 0)
                Toast.makeText(applicationContext, "Facebook", Toast.LENGTH_SHORT).show()
            list.removeAt(position)
            ad.notifyDataSetChanged()
        }
    }
}