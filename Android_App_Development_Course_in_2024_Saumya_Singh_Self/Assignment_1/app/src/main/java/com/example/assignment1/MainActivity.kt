package com.example.assignment1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.assignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.que1.setOnClickListener {
            val options =
                arrayOf("an operating system", "a web browser", "a web server", "None of the above")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("1) Android is -")
            builder.setSingleChoiceItems(
                options,
                -1,
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "You clicked on: ${options[which]}", Toast.LENGTH_SHORT)
                        .show()
                })
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT)
                        .show()
                })
            builder.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { dialogInterface, i ->
                })
            builder.show()
        }

        binding.que2.setOnClickListener {
            val options =
                arrayOf("OSS", "Sourceforge", "Apache/MIT", "None of the above")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("2) Under which of the following Android is licensed?")
            builder.setSingleChoiceItems(
                options,
                -1,
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "You clicked on: ${options[which]}", Toast.LENGTH_SHORT)
                        .show()
                })
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT)
                        .show()
                })
            builder.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { dialogInterface, i ->
                })
            builder.show()
        }

        binding.que3.setOnClickListener {
            val options =
                arrayOf("Servers", "Desktops", "Laptops", "Mobile devices")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("3) For which of the following Android is mainly developed?")
            builder.setSingleChoiceItems(
                options,
                -1,
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "You clicked on: ${options[which]}", Toast.LENGTH_SHORT)
                        .show()
                })
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT)
                        .show()
                })
            builder.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { dialogInterface, i ->
                })
            builder.show()
        }
    }
}