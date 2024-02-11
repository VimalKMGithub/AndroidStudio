package com.example.combined

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class Notifications : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        toolbar.title="Notifications"
        setSupportActionBar(toolbar)

        val bottomnav=findViewById<BottomNavigationView>(R.id.bottomnav)
        bottomnav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    startActivity(Intent(this,MainActivity::class.java))
                    true
                }
                R.id.settings->{
                    startActivity(Intent(this, Settings::class.java))
                    true
                }
                R.id.exit->{
                    finishAffinity()
                    true
                }
                else->{
                    false
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tb,menu)
        return super.onCreateOptionsMenu(menu)
    }
}