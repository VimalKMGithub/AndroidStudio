package com.example.customarrayadaptor

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CustomViewArrayAdaptor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view_array_adaptor)
        val listView = findViewById<ListView>(R.id.listView)
        val list = mutableListOf<Model>()

        list.add(Model("Facebook", "Facebook Description", R.drawable.fb))
        list.add(Model("Facebook2", "Facebook Description", R.drawable.fb))

        listView.adapter = MyAdapter(this, R.layout.listviewrow, list)
        listView.setOnItemClickListener { _: AdapterView<*>, _: View, position: Int, _: Long ->
            showToast(list[position].title)
        }
    }

    private var toast: Toast? = null
    private fun showToast(message: String) {
        if (toast != null) {
            toast?.cancel()
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }
}
