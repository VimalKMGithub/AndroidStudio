package com.example.customarrayadaptor

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CustomViewBaseAdapter : AppCompatActivity() {
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view_base_adapter)
    }
}