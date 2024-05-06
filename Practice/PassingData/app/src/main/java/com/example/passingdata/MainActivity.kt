package com.example.passingdata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val sub = findViewById<Button>(R.id.sub)
        sub.setOnClickListener {
            val i = Intent(this, Second::class.java)
            i.putExtra("Name", et1.text.toString())
            i.putExtra("Age", et2.text.toString())
            startActivity(i)
        }
    }
}