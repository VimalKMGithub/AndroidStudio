package com.example.ca02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class AddFixtureActivity : AppCompatActivity() {
    private val fixtureViewModel: FixtureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fixture)

        val editTextTeamA: EditText = findViewById(R.id.editTextTeamA)
        val editTextTeamB: EditText = findViewById(R.id.editTextTeamB)
        val editTextDate: EditText = findViewById(R.id.editTextDate)
        val editTextVenue: EditText = findViewById(R.id.editTextVenue)
        val buttonAddFixture: Button = findViewById(R.id.buttonAddFixture)

        buttonAddFixture.setOnClickListener {
            val fixture = Fixture(
                teamA = editTextTeamA.text.toString(),
                teamB = editTextTeamB.text.toString(),
                matchDate = editTextDate.text.toString(),
                venue = editTextVenue.text.toString()
            )
            fixtureViewModel.insert(fixture)
            finish() // Close the activity after adding
        }
    }
}