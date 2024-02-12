package com.example.passingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val t1 = findViewById<TextView>(R.id.tv1)
        val t2 = findViewById<TextView>(R.id.tv2)

        val name = intent.getStringExtra("Name").toString()
        val age = intent.getStringExtra("Age").toString()
        t1.text = "Name: $name"
        t2.text = "Age: $age"
    }
}