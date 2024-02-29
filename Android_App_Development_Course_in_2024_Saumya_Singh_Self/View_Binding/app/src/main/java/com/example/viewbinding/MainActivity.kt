package com.example.viewbinding

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val name = binding.etName.text.toString()
            val mail = binding.etMail.text.toString()
            if (name.isEmpty() && mail.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.checkBox.isChecked) {
                    startActivity(Intent(this, SecondActivity::class.java))
                } else {
                    binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.RED)
                    Toast.makeText(this, "Please accept the T&C", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}