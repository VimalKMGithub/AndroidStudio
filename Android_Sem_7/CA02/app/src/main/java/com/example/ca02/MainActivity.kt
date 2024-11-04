package com.example.ca02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddFixture: Button = findViewById(R.id.buttonAddFixture)
        val buttonViewFixtures: Button = findViewById(R.id.buttonViewFixtures)

        buttonAddFixture.setOnClickListener {
            startActivity(Intent(this, AddFixtureActivity::class.java))
        }

        buttonViewFixtures.setOnClickListener {
            startActivity(Intent(this, ViewFixturesActivity::class.java))
        }
    }
}