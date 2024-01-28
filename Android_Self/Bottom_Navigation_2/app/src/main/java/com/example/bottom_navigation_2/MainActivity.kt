package com.example.bottom_navigation_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bnView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnView = findViewById(R.id.bnView)
        replaceFragment(Home())
        bnView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.notifications -> replaceFragment(Notifications())
                R.id.settings -> replaceFragment(Settings())
                R.id.contactus -> replaceFragment(ContactUs())
                else -> replaceFragment(Profile())
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