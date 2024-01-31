package com.example.combined_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Notifications : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        val bnv = findViewById<BottomNavigationView>(R.id.bnView)
        bnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                }

                R.id.settings -> {
                    startActivity(Intent(this, Settings::class.java))
                }

                R.id.exit -> {
                    finish()
                }
            }
            true
        }
    }
}