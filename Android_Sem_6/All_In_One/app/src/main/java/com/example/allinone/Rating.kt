package com.example.allinone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class Rating : AppCompatActivity() {
    private lateinit var ratingBar: RatingBar
    private lateinit var sbButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        ratingBar = findViewById(R.id.ratingBar)
        sbButton = findViewById(R.id.sbButton)

        sbButton.setOnClickListener {
            val rating = ratingBar.rating
            Toast.makeText(
                this,
                "You gave a rating of $rating stars!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}