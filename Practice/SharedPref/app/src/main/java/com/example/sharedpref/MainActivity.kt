package com.example.sharedpref

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sha: SharedPreferences
    private lateinit var etn: TextView
    private lateinit var ete: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sha = getSharedPreferences("key", MODE_PRIVATE)
        etn = findViewById(R.id.etn)
        ete = findViewById(R.id.ete)
        etn.text = sha.getString("na", "")
        ete.text = sha.getString("em", "")
    }

    fun save(view: View) {
        sha.edit().putString("na", etn.text.toString()).putString("em", ete.text.toString()).apply()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    fun get(view: View) {
        etn.text = sha.getString("na", "")
        ete.text = sha.getString("em", "")
        Toast.makeText(this, "Retrieved", Toast.LENGTH_SHORT).show()
    }

    fun clear(view: View) {
        etn.text = ""
        ete.text = ""
    }
}