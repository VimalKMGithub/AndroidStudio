package com.example.wifi

import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var enableWife: Button? = null
    var disableWife: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableWife = findViewById<View>(R.id.enable) as Button
        disableWife = findViewById<View>(R.id.disable) as Button
        enableWife!!.setOnClickListener {
//            val wife = getSystemService(WIFI_SERVICE) as WifiManager
//            wife.setWifiEnabled(true)
//            WifiManager ob=new (WifiManager) context.getSystemService(WIFI_SERVICE)
        }
        disableWife!!.setOnClickListener {
            val wife = getSystemService(WIFI_SERVICE) as WifiManager
            wife.setWifiEnabled(false)
        }
    }
}