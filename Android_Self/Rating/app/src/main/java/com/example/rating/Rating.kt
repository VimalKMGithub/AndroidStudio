package com.example.rating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.fragment.app.Fragment

class Rating : Fragment() {

    private lateinit var ratingBar: RatingBar
    private lateinit var sbButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rating, container, false)
        ratingBar = view.findViewById(R.id.ratingBar)
        sbButton = view.findViewById(R.id.sbButton)

        sbButton.setOnClickListener {
            val rating = ratingBar.rating
            Toast.makeText(
                requireContext(),
                "You gave a rating of $rating stars!",
                Toast.LENGTH_SHORT
            ).show()
        }
        return view
    }
}
