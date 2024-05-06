package com.example.myalarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var stb: Button
    private lateinit var enb: Button
    private lateinit var et: EditText
    private lateinit var alm: AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stb = findViewById(R.id.stb)
        enb = findViewById(R.id.enb)
        et = findViewById(R.id.et)
        val int = Intent(this, MyRc::class.java)
        val pint = PendingIntent.getBroadcast(this, 234, int, PendingIntent.FLAG_MUTABLE)
        stb.setOnClickListener {
            alm = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alm.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (et.text.toString().toInt() * 1000),
                pint
            )
            Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show()
        }
        enb.setOnClickListener {
            alm = getSystemService(ALARM_SERVICE) as AlarmManager
            alm.cancel(pint)
            Toast.makeText(this, "Alarm Cancel", Toast.LENGTH_SHORT).show()
        }
    }
}