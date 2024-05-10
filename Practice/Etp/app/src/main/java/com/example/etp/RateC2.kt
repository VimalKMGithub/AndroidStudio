package com.example.etp

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RateC2 : AppCompatActivity() {
    private lateinit var rate: RatingBar
    private lateinit var sub: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_c2)
        sub = findViewById(R.id.sub2)
        rate = findViewById(R.id.rate2)
        sub.setOnClickListener {
            Toast.makeText(this, "You give ${rate.rating} rating to product 2", Toast.LENGTH_SHORT)
                .show()
        }
    }
}