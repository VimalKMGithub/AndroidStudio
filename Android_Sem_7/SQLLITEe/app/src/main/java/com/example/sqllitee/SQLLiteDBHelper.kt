package com.example.sqllitee

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLLiteDBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query =
            ("CREATE TABLE " + TABLE_NAME + " (" + ID_COL + " INTEGER PRIMARY KEY, " + NAME_COl + " TEXT," + AGE_COL + " TEXT" + ")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addName(name: String, age: String) {
        val values = ContentValues()
        values.put(NAME_COl, name)
        values.put(AGE_COL, age)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }

    fun delAll() {
        val db = this.writableDatabase
        db.execSQL("delete from " + TABLE_NAME);
        db.close()
    }

    companion object {
        private val DATABASE_NAME = "CSE_226_SQL"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "my_table"
        val ID_COL = "id"
        val NAME_COl = "name"
        val AGE_COL = "age"
    }
}