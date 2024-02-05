package com.example.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toEditText: EditText = findViewById(R.id.editTextText)
        val fromEditText: EditText = findViewById(R.id.editTextText2)
        val messageEditText: EditText = findViewById(R.id.editTextText3)
        val sendButton: Button = findViewById(R.id.button)
        sendButton.setOnClickListener {
            if (toEditText.text.toString().isBlank() || fromEditText.text.toString()
                    .isBlank() || messageEditText.text.toString().isBlank()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Message sent!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}