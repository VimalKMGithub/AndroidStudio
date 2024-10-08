package com.example.mysimplenotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    // declaring variables
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val btn = findViewById<Button>(R.id.b1)
            // it is a class to notify the user of events that happen.
            // This is how you tell the user that something has happened in the  background.
            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            btn.setOnClickListener {
                // pendingIntent is an intent for future use i.e after
                // the notification is clicked, this intent will come into action
                val intent = Intent(this, Second::class.java)
                // FLAG_UPDATE_CURRENT specifies that if a previous
                // PendingIntent already exists, then the current one will update it with the latest intent
                // 0 is the request code, using it later with the same method again will get back the same
                // pending intent for future reference intent passed here is to our second class.
                val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

                // RemoteViews are used to use the content of some different layout apart from the current activity layout
                val contentView = RemoteViews(packageName, R.layout.activity_splash_screen_example)

                // checking if android version is greater than oreo(API 26) or not
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                    notificationChannel.enableLights(true)
                    notificationChannel.lightColor = Color.GREEN
                    notificationChannel.enableVibration(false)
                    notificationManager.createNotificationChannel(notificationChannel)

                    builder = Notification.Builder(this, channelId)
                        .setContent(contentView)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
                        .setContentIntent(pendingIntent)
                } else {

                    builder = Notification.Builder(this)
                        .setContent(contentView)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
                        .setContentIntent(pendingIntent)
                }
                notificationManager.notify(1234, builder.build())
            }
        }
}


