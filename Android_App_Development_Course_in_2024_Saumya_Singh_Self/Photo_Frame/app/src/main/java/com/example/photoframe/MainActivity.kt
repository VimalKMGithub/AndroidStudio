package com.example.photoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.photoframe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindMain: ActivityMainBinding
    private var currentImage = 0
    lateinit var image: ImageView
    var names = arrayOf("Virat Kohli", "Saumya Singh", "Malala", "Priyanka Chopra")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMain.root)

        bindMain.imgPrev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            val idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage - 1) % 4
            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            bindMain.tvName.text = names[currentImage]
        }

        bindMain.imgNext.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            val idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage + 1) % 4
            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            bindMain.tvName.text = names[currentImage]
        }
    }
}