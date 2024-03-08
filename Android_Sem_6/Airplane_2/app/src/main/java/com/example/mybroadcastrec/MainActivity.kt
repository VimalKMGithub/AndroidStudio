package com.example.mybroadcastrec

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var receiver: AirplaneModeChange
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = AirplaneModeChange()
        // Intent Filter is useful to determine which apps wants to receive
        // which intents,since here we want to respond to change of airplane mode
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            // registering the receiver, it parameter which is passed in  registerReceiver() function
            // is the intent filter that we have just created
            registerReceiver(receiver, it)
        }
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}

/*      Dynamic Registration
        val filter = IntentFilter()
        filter.addAction("android.intent.action.ACTION_NAME")
// Add any other actions or intent filters if needed
        // Add any other actions or intent filters if needed
        val receiver = AirplaneModeChange()
        registerReceiver(receiver, filter)
*/
// since AirplaneModeChang class holds a instance of Context
// and that context is actually the activity context in which
// the receiver has been created
