package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val taskList = arrayListOf<String>()
        taskList.add("Visit shiv mandir")
        taskList.add("Attend exam")
        taskList.add("Complete app dev project")
        taskList.add("Work on resume")
        taskList.add("Improve internet presence")

        val adapterForMyListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        binding.listView.adapter = adapterForMyListView

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on item: " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}