package com.example.footer

import android.os.Bundle
import android.widget.Toast
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
                R.id.search -> Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                R.id.home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}