package com.example.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fc1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fc, Fragment1()).commit()
        }
        binding.fc2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fc, Fragment2()).commit()
        }
    }
}