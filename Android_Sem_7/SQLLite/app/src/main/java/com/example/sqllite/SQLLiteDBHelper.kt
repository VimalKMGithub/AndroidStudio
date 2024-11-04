package com.example.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLLiteDBHelper(context:Context,factory:SQLiteDatabase.CursorFactory?):SQLiteOpenHelper(context,DATABASE_NAME,factory,DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query=("CREATE TABLE "+TABLE_NAME+" ("+ID_COL+" INTEGER PrIMARY KEY,"+NAME_COL+" TEXT,"+AGE_COL+" TEXT"+")")
        if (db != null) {
            db.execSQL(query)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun delAll(){
        val db = this.writableDatabase
        db.execSQL("delete from"+TABLE_NAME)

    }
    companion object{
        private val DATABASE_NAME = "CSE_226_SQL"
        private val DATABASE_VERSION =1
        val TABLE_NAME = "my_table"
        val ID_COL = "id"
        val NAME_COL ="name"
        val AGE_COL ="age"
    }
}