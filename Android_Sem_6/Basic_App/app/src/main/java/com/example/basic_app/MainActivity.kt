package com.example.basic_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var nv: BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nv = findViewById(R.id.nav_bar)
        nv.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    true
                }

                R.id.profile -> {
                    true
                }

                R.id.setting -> {
                    true

                }

                R.id.exit -> {
                    finish()
                    false
                }

                else -> {
                    false
                }
            }
        }
    }
}