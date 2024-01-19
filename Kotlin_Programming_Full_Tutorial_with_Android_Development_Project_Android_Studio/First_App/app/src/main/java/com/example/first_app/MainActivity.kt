package com.example.first_app

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val buttonHot = findViewById<Button>(R.id.btnHot)
        val buttonCool = findViewById<Button>(R.id.btnCool)
        val linearLayout = findViewById<LinearLayout>(R.id.linLayout)

        buttonHot.setOnClickListener {
            linearLayout.setBackgroundColor(R.color.black)
        }

        buttonCool.setOnClickListener {
            linearLayout.setBackgroundColor(com.google.android.material.R.color.m3_ref_palette_dynamic_neutral0)
        }
    }
}