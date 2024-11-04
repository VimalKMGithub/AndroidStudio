package com.example.ca02

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewFixturesActivity : AppCompatActivity() {
    private val fixtureViewModel: FixtureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_fixtures)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFixtures)
        val adapter = FixtureAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        fixtureViewModel.allFixtures.observe(this) { fixtures ->
            fixtures?.let { adapter.submitList(it) }
        }
    }
}