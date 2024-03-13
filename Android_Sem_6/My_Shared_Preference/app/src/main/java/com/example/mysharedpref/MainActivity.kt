package com.example.mysharedpref

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var sharedpreferences: SharedPreferences
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var nameLabel: TextView
    private lateinit var emailLabel: TextView
    private val mypreference = "mypref"
    private val Name = "nameKey"
    private val Email = "emailKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.etName)
        emailEditText = findViewById(R.id.etEmail)
        nameLabel = findViewById(R.id.tvNameLabel)
        emailLabel = findViewById(R.id.tvEmailLabel)

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)

        nameEditText.setText(sharedpreferences.getString(Name, ""))
        emailEditText.setText(sharedpreferences.getString(Email, ""))
    }

    fun save(view: View?) {
        val n = nameEditText.text.toString()
        val e = emailEditText.text.toString()
        val editor = sharedpreferences.edit()
        editor.putString(Name, n)
        editor.putString(Email, e)
        editor.apply()
    }

    fun clear(view: View?) {
        nameEditText.text.clear()
        emailEditText.text.clear()
    }

    fun get(view: View) {
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        nameLabel.setText(sharedpreferences.getString(Name, ""))
        emailLabel.setText(sharedpreferences.getString(Email, ""))
    }
}
