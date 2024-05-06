package com.example.ztest

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var startButton: Button
    private var progressStatus = 0
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            startProcess()
        }
    }

    private fun startProcess() {
        progressStatus = 0
        progressBar.progress = progressStatus
        handler.postDelayed(object : Runnable {
            override fun run() {
                progressStatus++
                progressBar.progress = progressStatus
                if (progressStatus < 100) {
                    handler.postDelayed(this, 100)
                }
            }
        }, 100)
    }
}