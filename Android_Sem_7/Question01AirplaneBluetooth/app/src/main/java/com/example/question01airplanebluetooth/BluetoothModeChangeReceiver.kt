package com.example.question01airplanebluetooth

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BluetoothModeChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (BluetoothAdapter.ACTION_STATE_CHANGED == intent?.action) {
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