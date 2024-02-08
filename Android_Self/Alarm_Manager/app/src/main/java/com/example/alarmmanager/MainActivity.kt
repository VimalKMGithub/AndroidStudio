package com.example.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.button)
        val cancel = findViewById<Button>(R.id.cancel_button)
        val etext = findViewById<EditText>(R.id.time)
        var alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmManagerBroadcast::class.java)
        val requestCode = System.currentTimeMillis().toInt()
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        start.setOnClickListener {
            val i = etext.text.toString().toInt()
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (i * 1000),
                pendingIntent
            )
            Toast.makeText(this, "Alarm set in $i seconds", Toast.LENGTH_LONG).show()
        }

        cancel.setOnClickListener {
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

}