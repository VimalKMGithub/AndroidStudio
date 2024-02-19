package com.example.alarmusingjobscheduler

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent

class MyJobService : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        val intent = Intent(this@MyJobService, AlarmManagerBroadcast::class.java)
        val pendingIntent =
            PendingIntent.getBroadcast(this@MyJobService, 234, intent, PendingIntent.FLAG_MUTABLE)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent)
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return true
    }
}