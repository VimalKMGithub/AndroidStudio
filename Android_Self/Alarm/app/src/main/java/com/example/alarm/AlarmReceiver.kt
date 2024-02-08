package com.example.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.getStringExtra("ACTION")

        if ("PLAY" == action) {
            MediaPlayer.create(context, R.raw.alarm)?.apply {
                start()
            }
        }
    }
}

