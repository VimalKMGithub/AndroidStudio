package com.example.airplanebluetoothac

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneBluetoothReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)
                if (isAirplaneModeEnabled) {
                    Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_LONG).show()
                }
            }
            BluetoothAdapter.ACTION_STATE_CHANGED -> {
                val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
                when (state) {
                    BluetoothAdapter.STATE_OFF -> {
                        Toast.makeText(context, "Bluetooth is OFF", Toast.LENGTH_LONG).show()
                    }
                    BluetoothAdapter.STATE_ON -> {
                        Toast.makeText(context, "Bluetooth is ON", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}