package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sharedpreferences: SharedPreferences
    private lateinit var name: TextView
    private lateinit var email: TextView
    val mypreference = "mypref"
    val Name = "nameKey"
    val Email = "emailKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.etName)
        email = findViewById(R.id.etMail)
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        name.text = sharedpreferences.getString(Name, "")
        email.text = sharedpreferences.getString(Email, "")
    }

    fun save(view: View?) {
        val n = name.text.toString()
        val e = email.text.toString()
        val editor = sharedpreferences.edit()
        editor.putString(Name, n)
        editor.putString(Email, e)
        editor.apply()
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
    }

    fun clear(view: View?) {
        name.text = ""
        email.text = ""
        Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show()
    }

    fun get(view: View) {
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        name.text = sharedpreferences.getString(Name, "")
        email.text = sharedpreferences.getString(Email, "")
        Toast.makeText(this, "Fetched", Toast.LENGTH_SHORT).show()
    }
}