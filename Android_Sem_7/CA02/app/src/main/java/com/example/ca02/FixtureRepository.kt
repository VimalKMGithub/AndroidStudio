package com.example.ca02

import androidx.lifecycle.LiveData

class FixtureRepository(private val fixtureDao: FixtureDao) {
    val allFixtures: LiveData<List<Fixture>> = fixtureDao.getAllFixtures()

    suspend fun insert(fixture: Fixture) {
        fixtureDao.insertFixture(fixture)
    }

    suspend fun delete(fixture: Fixture) {
        fixtureDao.deleteFixture(fixture)
    }
}