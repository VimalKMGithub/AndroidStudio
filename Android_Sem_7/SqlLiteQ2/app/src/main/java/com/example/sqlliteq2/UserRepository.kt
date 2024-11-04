package com.example.sqlliteq2

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream

class UserRepository(private val dbHelper: DatabaseHelper) {

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }

    fun insertUser(name: String, bitmap: Bitmap): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DatabaseHelper.COLUMN_NAME, name)
        contentValues.put(DatabaseHelper.COLUMN_IMAGE, bitmapToByteArray(bitmap))
        return db.insert(DatabaseHelper.TABLE_NAME, null, contentValues)
    }

    private fun byteArrayToBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

    fun getAllUsers(): List<User> {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val userList = mutableListOf<User>()

        val cursor: Cursor = db.query(
            DatabaseHelper.TABLE_NAME,
            arrayOf(
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_IMAGE
            ),
            null, null, null, null, null
        )

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID))
                val name =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME))
                val imageByteArray =
                    cursor.getBlob(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_IMAGE))
                val bitmap = byteArrayToBitmap(imageByteArray)

                userList.add(User(id, name, bitmap))
            } while (cursor.moveToNext())
        }

        cursor.close()
        return userList
    }
}