package com.example.externalstorageexample

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import android.Manifest;

class MainActivity : AppCompatActivity() {
    lateinit var uname: EditText
    lateinit var pwd: EditText
    lateinit var saveBtn: Button

    lateinit var fstream: FileOutputStream
    private val filename = "SampleFile.txt"
    private val filepath = "MyFileStorage"
    lateinit var myExternalFile: File

    var mPermission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uname = findViewById(R.id.txtName)
        pwd = findViewById(R.id.txtPwd)
        saveBtn = findViewById(R.id.btnSave)
        saveBtn.setOnClickListener {
            val username = """
                ${uname.text}
                
                """.trimIndent()
            val password = pwd.text.toString()
            try {
                if (ContextCompat.checkSelfPermission(this, mPermission[0]) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, mPermission[1]) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, mPermission, 23)
                } else {
                    if (username.isEmpty() || password.isEmpty())
                        Toast.makeText(this, "either of field is empty", Toast.LENGTH_SHORT).show()
                    else {
                        myExternalFile = File(getExternalFilesDir(filepath), filename)
                        fstream = FileOutputStream(myExternalFile)
                        fstream.write(username.toByteArray())
                        fstream.write(password.toByteArray())
                        fstream.close()
                        Toast.makeText(applicationContext, "Details Saved in " + myExternalFile!!.absolutePath, Toast.LENGTH_LONG).show()
                        intent = Intent(this, ExternalDetails::class.java)
                        startActivity(intent)
                    }
                }
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }
}