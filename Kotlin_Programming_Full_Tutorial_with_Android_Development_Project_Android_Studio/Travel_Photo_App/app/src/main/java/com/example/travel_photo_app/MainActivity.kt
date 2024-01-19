package com.example.travel_photo_app

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var currentImage = 0
    lateinit var image: ImageView
    var places = arrayOf("India Gate", "Prem Mandir", "Golden Temple", "Bagha Border", "Ram Mandir")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.placeName)

        next.setOnClickListener {
            var idCurrentImageString = "pic$currentImage"
            var idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (6 + currentImage) % 5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
        }

        prev.setOnClickListener {
            var idCurrentImageString = "pic$currentImage"
            var idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage) % 5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
        }
    }
}