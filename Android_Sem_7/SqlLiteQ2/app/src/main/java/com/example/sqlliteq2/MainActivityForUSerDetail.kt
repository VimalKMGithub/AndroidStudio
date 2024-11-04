package com.example.sqlliteq2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivityForUSerDetail : AppCompatActivity() {
    private lateinit var etUserName: EditText
    private lateinit var ivUserImage: ImageView
    private lateinit var btnPickImage: Button
    private lateinit var btnSaveUser: Button
    private lateinit var lvUsers: ListView

    private var selectedBitmap: Bitmap? = null
    private val PICK_IMAGE_REQUEST = 1

    private lateinit var userRepository: UserRepository

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_for_user_detail)


        etUserName = findViewById(R.id.etUserName)
        ivUserImage = findViewById(R.id.ivUserImage)
        btnPickImage = findViewById(R.id.btnPickImage)
        btnSaveUser = findViewById(R.id.btnSaveUser)
        lvUsers = findViewById(R.id.lvUsers)

        val dbHelper = DatabaseHelper(this)
        userRepository = UserRepository(dbHelper)

        btnPickImage.setOnClickListener {
            pickImageFromGallery()
        }

        btnSaveUser.setOnClickListener {
            val name = etUserName.text.toString()
            if (name.isNotEmpty() && selectedBitmap != null) {
                userRepository.insertUser(name, selectedBitmap!!)
                Toast.makeText(this, "User saved", Toast.LENGTH_SHORT).show()
                loadUsers()
            } else {
                Toast.makeText(this, "Enter name and select an image", Toast.LENGTH_SHORT).show()
            }
        }

        loadUsers()
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            if (imageUri != null) {
                selectedBitmap = if (Build.VERSION.SDK_INT < 28) {
                    MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
                } else {
                    val source = ImageDecoder.createSource(this.contentResolver, imageUri)
                    ImageDecoder.decodeBitmap(source)
                }
                ivUserImage.setImageBitmap(selectedBitmap)
            }
        }
    }

    private fun loadUsers() {
        val userList = userRepository.getAllUsers()
        val adapter = UserAdapter(this, userList)
        lvUsers.adapter = adapter
    }
}