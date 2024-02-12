package com.example.passingdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val e1 = findViewById<EditText>(R.id.et1)
        val e2 = findViewById<EditText>(R.id.et2)
        val b1 = findViewById<Button>(R.id.b1)

        b1.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("Name", e1.text.toString())
            i.putExtra("Age", e2.text.toString())
            startActivity(i)
        }
    }
}