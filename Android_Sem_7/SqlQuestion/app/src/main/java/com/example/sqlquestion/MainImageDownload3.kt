package com.example.sqlquestion

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainImageDownload3 : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var btnPickImage: Button
    private lateinit var btnSaveImage: Button
    private lateinit var btnShowImage: Button
    lateinit var getImage: ActivityResultLauncher<String>
    private var selectedBitmap: Bitmap? = null
    private val PICK_IMAGE_REQUEST = 1
    lateinit var imageU: Uri

    private lateinit var imageRepository: ImageRepository

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_image_download3)
        imageView = findViewById(R.id.imageView)
        btnPickImage = findViewById(R.id.btnPickImage)
        btnSaveImage = findViewById(R.id.btnSaveImage)
        btnShowImage = findViewById(R.id.btnShowImage)
        imageView2 = findViewById(R.id.imageView2)

        val dbHelper = DatabaseHelper(this)
        imageRepository = ImageRepository(dbHelper)

        getImage =
            registerForActivityResult(ActivityResultContracts.GetContent(), ActivityResultCallback {
                if (it != null) {
                    imageU = it
                }
                imageView.setImageURI(it)
            })
        btnPickImage.setOnClickListener {
            getImage.launch("image/*")
        }

        btnSaveImage.setOnClickListener {
            if (imageU != null) {
                selectedBitmap = if (Build.VERSION.SDK_INT < 28) {
                    MediaStore.Images.Media.getBitmap(this.contentResolver, imageU)
                } else {
                    val source = ImageDecoder.createSource(this.contentResolver, imageU)
                    ImageDecoder.decodeBitmap(source)
                }
                selectedBitmap?.let {
                    val id = imageRepository.insertImage(it)
                    Toast.makeText(this, "Image saved with ID: $id", Toast.LENGTH_SHORT).show()
                } ?: Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show()
            }
        }

        btnShowImage.setOnClickListener {
            val bitmap = imageRepository.getImage()
            if (bitmap != null) {
                imageView2.setImageBitmap(bitmap)
                Toast.makeText(this, "Image retrieved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No image found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}