package com.example.kuldeep

import android.os.Bundle
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VideoCoRoutine : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_video_co_routine)

        videoView = findViewById(R.id.videoview)
        progressBar = findViewById(R.id.progressBar)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        progressBar.visibility = ProgressBar.VISIBLE

        CoroutineScope(Dispatchers.IO).launch{
            val videoUrl = loadVideoUrl()

            withContext(Dispatchers.Main){
                playVideo(videoUrl)
            }
        }

        videoView.setOnPreparedListener {
            progressBar.visibility = ProgressBar.GONE
        }
    }

    private suspend fun loadVideoUrl(): String{
        delay(1000)
        return "https://mazwai.com/videvo_files/video/free/2018-12/small_watermarked/180607_A_124_preview.mp4"
    }

    private fun playVideo(videoUrl: String){
        videoView.setVideoPath(videoUrl)
        videoView.start()
    }
}