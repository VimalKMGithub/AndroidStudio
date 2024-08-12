package com.example.arrayadaptercustom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CustomArrayAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_array_adapter)

        val listView = findViewById<ListView>(R.id.listView)
        val list = mutableListOf<Model>()

        list.add(Model("Facebook", "Facebook Description", R.drawable.facebook))
        list.add(Model("Google Drive", "Google Drive Description", R.drawable.googledrive))
        list.add(Model("Google Map", "Google Map Description", R.drawable.googlemap))
        list.add(Model("Instagram", "Instagram Description", R.drawable.instagram))
        list.add(Model("Linkedin", "Linkedin Description", R.drawable.linkedin))
        list.add(Model("Pinterest", "Pinterest Description", R.drawable.pinterest))
        list.add(Model("Playstore", "Playstore Description", R.drawable.playstore))
        list.add(Model("Reddit", "Reddit Description", R.drawable.reddit))
        list.add(Model("Snapchat", "Snapchat Description", R.drawable.snapchat))
        list.add(Model("Telegram", "Telegram Description", R.drawable.telegram))
        list.add(Model("Whatsapp", "Whatsapp Description", R.drawable.whatsapp))
        list.add(Model("X", "X Description", R.drawable.x))
        list.add(Model("Youtube", "Youtube Description", R.drawable.youtube))

        listView.adapter = MyAdapter(this, R.layout.list_view_row, list)
        listView.setOnItemClickListener { _: AdapterView<*>, _: View, position: Int, _: Long ->
            when (position) {
                0 -> startActivity(Intent(this, FacebookActivity::class.java))
                1 -> Toast.makeText(applicationContext, "Google Drive", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(applicationContext, "Google Map", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(applicationContext, "Instagram", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(applicationContext, "Linkedin", Toast.LENGTH_SHORT).show()
                5 -> Toast.makeText(applicationContext, "Pinterest", Toast.LENGTH_SHORT).show()
                6 -> Toast.makeText(applicationContext, "Playstore", Toast.LENGTH_SHORT).show()
                7 -> Toast.makeText(applicationContext, "Reddit", Toast.LENGTH_SHORT).show()
                8 -> Toast.makeText(applicationContext, "Snapchat", Toast.LENGTH_SHORT).show()
                9 -> Toast.makeText(applicationContext, "Telegram", Toast.LENGTH_SHORT).show()
                10 -> Toast.makeText(applicationContext, "Whatsapp", Toast.LENGTH_SHORT).show()
                11 -> Toast.makeText(applicationContext, "X", Toast.LENGTH_SHORT).show()
                12 -> Toast.makeText(applicationContext, "Youtube", Toast.LENGTH_SHORT).show()
                else -> {}
            }
        }
    }
}