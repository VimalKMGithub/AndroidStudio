package com.example.combined_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.nav)
        setSupportActionBar(toolbar)

        val btnToast = findViewById<Button>(R.id.btnClick)
        btnToast.setOnClickListener {
            val vg: ViewGroup? = findViewById(R.id.my_viewgroup)
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_toast, vg)
            val tv = layout.findViewById<TextView>(R.id.custom_toast_message)
            tv.text = "My Message"
            val toast = Toast(applicationContext)
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100)
            toast.duration = Toast.LENGTH_LONG
            toast.setView(layout)
            toast.show()


//            val vg = findViewById<ViewGroup>(R.id.my_viewgroup)
//            val layout = layoutInflater.inflate(R.layout.custom_toast, vg)
//            val tv = layout.findViewById<TextView>(R.id.custom_toast_message)
//            "My Message".also { tv.text = it }
//            val toast = Toast(applicationContext)
//            toast.duration = Toast.LENGTH_SHORT
//            toast.view = layout
//            toast.show()
        }

        val bnv = findViewById<BottomNavigationView>(R.id.bnView)
        bnv.selectedItemId = R.id.home
        bnv.setOnItemSelectedListener {
            when (it.itemId) {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.head_view, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.notifications -> {
                startActivity(Intent(this, Notifications::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}