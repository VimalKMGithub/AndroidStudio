package com.example.ca02

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FixtureViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FixtureRepository
    val allFixtures: LiveData<List<Fixture>>

    init {
        val fixtureDao = AppDatabase.getDatabase(application).fixtureDao()
        repository = FixtureRepository(fixtureDao)
        allFixtures = repository.allFixtures
    }

    fun insert(fixture: Fixture) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(fixture)
    }

    fun delete(fixture: Fixture) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(fixture)
    }
}