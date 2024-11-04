package com.example.ca02

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixture_table")
data class Fixture(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val teamA: String,
    val teamB: String,
    val matchDate: String,
    val venue: String
)