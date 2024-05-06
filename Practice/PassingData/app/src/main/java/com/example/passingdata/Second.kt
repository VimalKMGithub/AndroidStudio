package com.example.passingdata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val tv1 = findViewById<TextView>(R.id.tv1)
        val tv2 = findViewById<TextView>(R.id.tv2)
        tv1.text = intent.getStringExtra("Name")
        tv2.text = intent.getStringExtra("Age")
    }
}
