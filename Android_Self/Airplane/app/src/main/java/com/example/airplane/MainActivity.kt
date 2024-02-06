package com.example.airplane

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enableButton: Button = findViewById(R.id.enableButton)
        val disableButton: Button = findViewById(R.id.disableButton)

        enableButton.setOnClickListener {
            setAirplaneMode(true)
        }

        disableButton.setOnClickListener {
            setAirplaneMode(false)
        }
    }

    private fun setAirplaneMode(enable: Boolean) {
        try {
            // Check if airplane mode is already in the desired state
            if (isAirplaneModeOn() == enable) {
                showToast("Airplane mode is already ${if (enable) "enabled" else "disabled"}")
                return
            }

            // Change airplane mode using Intent
            val intent = Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("airplane_mode", enable)
            sendBroadcast(intent)

            showToast("Airplane mode ${if (enable) "enabled" else "disabled"}")
        } catch (e: Exception) {
            showToast("Failed to ${if (enable) "enable" else "disable"} airplane mode")
        }
    }

    private fun isAirplaneModeOn(): Boolean {
        return Settings.System.getInt(
            contentResolver,
            Settings.Global.AIRPLANE_MODE_ON, 0
        ) != 0
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
