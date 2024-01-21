package com.example.splash_screen

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var sc: ScrollView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rb: RatingBar = findViewById(R.id.simpleRatingBar)
        val rateT: TextView = findViewById(R.id.tv1)
        val subBtn: Button = findViewById(R.id.submitButton)
        val rb1: RatingBar = findViewById(R.id.simpleRating)
        subBtn.setOnClickListener() {
            var rating = "Rating :: " + rb.rating
            var r1 = rb.rating
            var r2 = rb1.rating
            var avg = (r1 + r2) / 2
            rb.rating = avg
            when (avg.toInt()) {
                5 -> {
                    rateT.setText("best")
                }

                4 -> {
                    rateT.setText("good")
                }

                3 -> {
                    rateT.setText("average")
                }

                2 -> {
                    rateT.setText("bad")
                }

                else ->
                    rateT.setText("worst")
            }
            Toast.makeText(this, rating, Toast.LENGTH_SHORT).show()
        }
    }
}