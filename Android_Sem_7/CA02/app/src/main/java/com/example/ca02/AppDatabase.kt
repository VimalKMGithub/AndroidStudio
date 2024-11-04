package com.example.ca02

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Fixture::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fixtureDao(): FixtureDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fixture_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}