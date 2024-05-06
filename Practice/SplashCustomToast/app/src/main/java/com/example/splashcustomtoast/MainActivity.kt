package com.example.splashcustomtoast

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var ct: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ct = findViewById(R.id.ct)
        ct.setOnClickListener {
            val vg = findViewById<ViewGroup>(R.id.ctl)
            val ly = layoutInflater.inflate(R.layout.ct, vg)
            val tv = ly.findViewById<TextView>(R.id.ctm)
            "Created By Vimal Kumar Mishra".also { tv.text = it }
            val toast = Toast(applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = ly
            toast.show()
        }
    }
}