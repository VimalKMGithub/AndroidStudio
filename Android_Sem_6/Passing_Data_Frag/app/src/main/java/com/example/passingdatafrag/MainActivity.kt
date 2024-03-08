package com.example.passingdatafrag

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun passData(editTextArgs: String) {
        val bundle = Bundle()
        bundle.putString("message",editTextArgs)
        val transaction=this.supportFragmentManager.beginTransaction()
        val fragment1=A()
        fragment1.arguments(R.id.fc).comm
    }
}