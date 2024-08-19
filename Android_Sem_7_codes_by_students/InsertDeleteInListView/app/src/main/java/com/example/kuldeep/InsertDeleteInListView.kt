package com.example.kuldeep

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InsertDeleteInListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_insert_delete_in_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var titleInput = findViewById<EditText>(R.id.titleInput)
        var descriptionInput = findViewById<EditText>(R.id.descriptionInput)
        var addBtn = findViewById<Button>(R.id.addBtn)
        var listview = findViewById<ListView>(R.id.listview)

        // variables for adapter
        var list = ArrayList<DataModel>()

        // listview using Base Adapter
        var adapter = BaseAdapter(this, list)
        listview.adapter = adapter
        // actions performed when we click add button
        addBtn.setOnClickListener {
            // check for both inputs (both are filled)
            if(titleInput.text.toString() == "" || descriptionInput.text.toString() == "") {
                showToast("Please enter both title and description")
            }else{
                // add in list
                list.add(DataModel(titleInput.text.toString(), descriptionInput.text.toString()))
                adapter.notifyDataSetChanged()
                titleInput.setText("")
                descriptionInput.setText("")
                showToast("Item Added")
            }
        }

        // delete onclicking item
        listview.setOnItemClickListener { parent, view, position, id ->
            showToast("Item Deleted")
            list.removeAt(position)
            adapter.notifyDataSetChanged()
        }

    }

    private var toast: Toast? = null
    private fun showToast(text: String) {
        toast?.cancel()
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        toast?.show()
    }
}