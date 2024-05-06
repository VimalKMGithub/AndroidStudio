package com.example.myalarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.widget.Toast

class MyRc : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val mp = MediaPlayer.create(context, R.raw.alarm)
        mp.start()
        Toast.makeText(context, "Alarm started", Toast.LENGTH_SHORT).show()
    }
}