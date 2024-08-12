package com.example.kuldeep

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShowItemDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show_item_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // get intent data
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val image = intent.getIntExtra("image", 0)

        // set intent data into layout
        findViewById<TextView>(R.id.title).text = title
        findViewById<TextView>(R.id.description).text = description
        findViewById<ImageView>(R.id.imageview).setImageResource(image)
    }
}