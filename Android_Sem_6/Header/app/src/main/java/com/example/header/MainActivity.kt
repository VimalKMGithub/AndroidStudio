package com.example.header

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add -> {
                Toast.makeText(this, "Add menu item", Toast.LENGTH_LONG).show()
                true
            }

            R.id.list_item -> {
                Toast.makeText(this, "List items", Toast.LENGTH_LONG).show()
                true
            }

            R.id.exit -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}