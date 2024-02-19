package com.example.alarmusingjobscheduler

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer

class AlarmManagerBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val mp = MediaPlayer.create(context, R.raw.alarm)
        mp.start()
    }
}