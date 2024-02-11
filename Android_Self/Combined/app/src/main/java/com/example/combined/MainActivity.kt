package com.example.combined

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        toolbar.title="Home"
        setSupportActionBar(toolbar)

        val bottomnav=findViewById<BottomNavigationView>(R.id.bottomnav)
        bottomnav.setOnItemSelectedListener {
            when(it.itemId){
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.notifications -> {
                startActivity(Intent(this, Notifications::class.java))
                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }
    }
}