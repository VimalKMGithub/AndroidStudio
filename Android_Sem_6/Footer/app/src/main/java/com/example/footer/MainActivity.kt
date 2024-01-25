package com.example.footer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var nv:BottomNavigationView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nv=findViewById(R.id.nav_bar)
        nv.setOnItemSelectedListener { menuItem->
            when(menuItem.itemId){
                R.id.home->{
                    Toast.makeText(this,"Home",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.setting->{
                    Toast.makeText(this,"action",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.search->{
                    Toast.makeText(this,"search",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.exit->{
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