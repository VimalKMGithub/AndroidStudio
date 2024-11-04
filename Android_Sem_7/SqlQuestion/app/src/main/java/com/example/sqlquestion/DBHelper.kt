package com.example.sqlquestion

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "students.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "students"
        private const val COL_SLNO = "sl_no"
        private const val COL_FIRST_NAME = "first_name"
        private const val COL_LAST_NAME = "last_name"
        private const val COL_MOBILE_NUMBER = "mobile_number"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_NAME ("
                + "$COL_SLNO INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COL_FIRST_NAME TEXT NOT NULL, "
                + "$COL_LAST_NAME TEXT NOT NULL, "
                + "$COL_MOBILE_NUMBER TEXT NOT NULL)")
        db?.execSQL(createTable)
        insertInitialData(db)
    }

    private fun insertInitialData(db: SQLiteDatabase?) {
        val students = listOf(
            arrayOf("John", "Doe", "1234567890"),
            arrayOf("Jane", "Doe", "0987654321"),
            arrayOf("Sam", "Smith", "1231231234"),
            arrayOf("Lisa", "Simpson", "3213214321"),
            arrayOf("Mike", "Ross", "5555551234"),
            arrayOf("Rachel", "Zane", "4444446789"),
            arrayOf("Harvey", "Specter", "2222229876"),
            arrayOf("Donna", "Paulsen", "6666662345"),
            arrayOf("Louis", "Litt", "9999995678"),
            arrayOf("Jessica", "Pearson", "7777770987"),
            arrayOf("Tom", "Holland", "3333331122"),
            arrayOf("Chris", "Evans", "5555553344"),
            arrayOf("Robert", "Downey", "8888885566"),
            arrayOf("Scarlett", "Johansson", "2222227788"),
            arrayOf("Mark", "Ruffalo", "9999993344"),
            arrayOf("Jeremy", "Renner", "1111116677"),
            arrayOf("Paul", "Rudd", "4444448899"),
            arrayOf("Brie", "Larson", "7777777788"),
            arrayOf("Chadwick", "Boseman", "1234561234"),
            arrayOf("Tom", "Hiddleston", "9876543210")
        )

        students.forEach { student ->
            val values = ContentValues().apply {
                put(COL_FIRST_NAME, student[0])
                put(COL_LAST_NAME, student[1])
                put(COL_MOBILE_NUMBER, student[2])
            }
            db?.insert(TABLE_NAME, null, values)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun getAllStudents(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
}