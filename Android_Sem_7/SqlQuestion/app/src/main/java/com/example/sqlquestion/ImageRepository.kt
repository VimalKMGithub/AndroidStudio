package com.example.sqlquestion

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream

class ImageRepository(private val dbHelper: DatabaseHelper) {
    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }

    fun insertImage(bitmap: Bitmap): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DatabaseHelper.COLUMN_IMAGE, bitmapToByteArray(bitmap))
        return db.insert(DatabaseHelper.TABLE_NAME, null, contentValues)
    }

    private fun byteArrayToBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

    fun getImage(): Bitmap? {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor = db.query(
            DatabaseHelper.TABLE_NAME,
            arrayOf(DatabaseHelper.COLUMN_IMAGE),
            null, null, null, null, "${DatabaseHelper.COLUMN_ID} DESC", "1"
        )
        return if (cursor.moveToFirst()) {
            val imageByteArray =
                cursor.getBlob(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_IMAGE))
            cursor.close()
            byteArrayToBitmap(imageByteArray)
        } else {
            cursor.close()
            null
        }
    }
}