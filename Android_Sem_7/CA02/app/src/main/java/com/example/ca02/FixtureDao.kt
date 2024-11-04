package com.example.ca02

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FixtureDao {
    @Insert
    suspend fun insert(fixture: Fixture): Long  // Correct method signature

    @Query("SELECT * FROM fixture_table ORDER BY id ASC")
    fun getAllFixtures(): Flow<List<Fixture>>
}