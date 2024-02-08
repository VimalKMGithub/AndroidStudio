package com.example.alarm

// MainActivity.kt
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private var mediaPlayer: MediaPlayer? = null
    private var pendingIntent: PendingIntent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)

        startButton.setOnClickListener {
            startMusic()
        }

        stopButton.setOnClickListener {
            stopMusic()
        }
    }

    private fun startMusic() {
        val delaySeconds = editText.text.toString().toIntOrNull() ?: 0

        // Create an Intent to play the music
        val intent = Intent(this, AlarmReceiver::class.java)
        intent.putExtra("ACTION", "PLAY")

        pendingIntent = PendingIntent.getBroadcast(
            this, 0, intent,
            PendingIntent.FLAG_IMMUTABLE  // Set FLAG_IMMUTABLE to make the PendingIntent immutable
        )

        // Set an alarm to trigger after the specified number of seconds
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + delaySeconds * 1000,
            pendingIntent!!
        )
    }

    private fun stopMusic() {
        // Cancel the alarm and release the PendingIntent
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        pendingIntent?.let {
            alarmManager.cancel(it)
            it.cancel()
        }

        // Stop and release the MediaPlayer
        mediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        mediaPlayer = null
    }
}