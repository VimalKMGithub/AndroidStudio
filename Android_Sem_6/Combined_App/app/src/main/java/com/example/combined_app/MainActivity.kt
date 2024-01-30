package com.example.combined_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        }

    }
}