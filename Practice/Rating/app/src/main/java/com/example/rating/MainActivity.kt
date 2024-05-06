package com.example.rating

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rate: RatingBar
    private lateinit var sub: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sub = findViewById(R.id.sub)
        rate = findViewById(R.id.rate)
        sub.setOnClickListener {
            Toast.makeText(this, "You give ${rate.rating}", Toast.LENGTH_SHORT).show()
        }
    }
}