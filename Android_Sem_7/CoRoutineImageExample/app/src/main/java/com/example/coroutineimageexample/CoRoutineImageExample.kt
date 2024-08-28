package com.example.coroutineimageexample

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class CoRoutineImageExample : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private val imageUrl =
        "https://img.freepik.com/free-vector/cute-happy-smiling-child-isolated-white_1308-32243.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_co_routine_image_example)
        imageView = findViewById(R.id.imageView)
        lifecycleScope.launch(Dispatchers.IO) {
            val imageData = fetchImage(imageUrl)
            if (imageData != null) {
                val bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.size)
                withContext(Dispatchers.Main) {
                    imageView.setImageBitmap(bitmap)
                }
            }

        }
    }

    private suspend fun fetchImage(url: String): ByteArray? {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                response.body?.bytes()
            } else {
                null
            }
        }
    }
}


//package com.example.coroutineimageexample
//
//import android.graphics.BitmapFactory
//import android.os.Bundle
//import android.widget.ImageView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.lifecycleScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import java.net.HttpURLConnection
//import java.net.URL
//
//class CoRoutineImageExample : AppCompatActivity() {
//    private lateinit var imageView: ImageView
//    private val imageUrl =
//        "https://img.freepik.com/free-vector/cute-happy-smiling-child-isolated-white-background_1308-70460.jpg?t=st=1724659050~exp=1724662650~hmac=7d5d42e30454ac8d8b190b037ebe477e4f344826a7f978744b3c13b4593dcc35&w=360"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_co_routine_image_example)
//
//        imageView = findViewById(R.id.imageView)
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            val imageData = fetchImage(imageUrl)
//            if (imageData != null) {
//                val bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.size)
//                withContext(Dispatchers.Main) {
//                    imageView.setImageBitmap(bitmap)
//                }
//            }
//        }
//    }
//
//    private fun fetchImage(imageUrl: String): ByteArray? {
//        return try {
//            val url = URL(imageUrl)
//            val connection = url.openConnection() as HttpURLConnection
//            connection.inputStream.use { it.readBytes() }
//        } catch (e: Exception) {
//            e.printStackTrace()
//            null
//        }
//    }
//}