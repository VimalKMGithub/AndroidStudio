package com.example.mynotification

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NotificationViewExample : AppCompatActivity() {
    private lateinit var notificationManager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_view_example)

        val txtView = findViewById<TextView>(R.id.tv1)
        val notificationId = intent.getIntExtra("notificationId", -1)
        val myKey = intent.getStringExtra("myKey")
        val bundle: Bundle? = RemoteInput.getResultsFromIntent(intent)
        if (bundle != null && myKey != null) {
            val inputText = bundle.getCharSequence(myKey)
            txtView.text = inputText
        }
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (notificationId != -1) {
            notificationManager.cancel(notificationId)
        }
    }
}