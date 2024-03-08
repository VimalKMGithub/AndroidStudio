package com.example.mybroadcastrec

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class AirplaneModeChange : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (isAirplaneModeOn(context.applicationContext)) {
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "AirPlane mode is off", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private fun isAirplaneModeOn(context: Context): Boolean {
            return Settings.System.getInt(
                context.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON,
                0
            ) != 0
        }
    }
}
