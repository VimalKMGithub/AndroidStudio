package com.example.etp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bnv: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnv = findViewById(R.id.bnv)
        bnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.r1 -> startActivity(Intent(this, RateC1::class.java))
                R.id.r2 -> startActivity(Intent(this, RateC2::class.java))
            }
            true
        }
    }
}