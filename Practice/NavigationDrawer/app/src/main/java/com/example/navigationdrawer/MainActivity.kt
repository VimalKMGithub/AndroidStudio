package com.example.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drl: DrawerLayout
    private lateinit var nv: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tb = findViewById<Toolbar>(R.id.tb)
        setSupportActionBar(tb)
        drl = findViewById(R.id.drl)
        nv = findViewById(R.id.nv)
        nv.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this, drl, tb, R.string.drop, R.string.drcl)
        drl.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fc, HomeFragment()).commit()
            nv.setCheckedItem(R.id.home)
        }
    }

    override fun onBackPressed() {
        if (drl.isDrawerOpen(GravityCompat.START)) {
            drl.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> supportFragmentManager.beginTransaction().replace(R.id.fc, HomeFragment())
                .commit()

            R.id.message -> supportFragmentManager.beginTransaction()
                .replace(R.id.fc, MessageFragment()).commit()
        }
        drl.closeDrawer(GravityCompat.START)
        return true
    }
}