package com.example.interactive_app

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonLight = findViewById<Button>(R.id.btnLight)
        val layout = findViewById<LinearLayout>(R.id.linLayout)
        buttonLight.setOnClickListener {
            layout.setBackgroundResource(R.color.white)
        }
        buttonDark.setOnClickListener {
            layout.setBackgroundResource(R.color.black)
        }
    }
}