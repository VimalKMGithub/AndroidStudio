package com.example.basic_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bnView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnView = findViewById(R.id.bottomNavigationView)
        replaceFragment(Home())
        bnView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(Home())
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }

                R.id.notifications -> {
                    replaceFragment(Notifications())
                    Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
                }

                R.id.settings -> {
                    replaceFragment(Settings())
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    replaceFragment(Profile())
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}