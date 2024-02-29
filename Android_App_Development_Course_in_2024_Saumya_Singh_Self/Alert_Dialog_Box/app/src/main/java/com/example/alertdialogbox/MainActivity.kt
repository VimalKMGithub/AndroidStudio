package com.example.alertdialogbox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are You Sure?")
            builder1.setMessage("Do You Want To Close The App?")
            builder1.setIcon(R.drawable.exit)
            builder1.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    finish()
                })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmallai", "Kaju Katli")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is Your Favourite sweet?")
            builder2.setSingleChoiceItems(
                options,
                0,
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "You clicked on: ${options[i]}", Toast.LENGTH_SHORT).show()
                })
            builder2.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                })
            builder2.setNegativeButton(
                "Decline",
                DialogInterface.OnClickListener { dialogInterface, i ->
                })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmallai", "Kaju Katli")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which is Your Favourite sweet?")
            builder3.setMultiChoiceItems(
                options,
                null,
                DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                    Toast.makeText(this, "You clicked on: ${options[which]}", Toast.LENGTH_SHORT)
                        .show()
                })
            builder3.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                })
            builder3.setNegativeButton(
                "Decline",
                DialogInterface.OnClickListener { dialogInterface, i ->
                })
            builder3.show()
        }
    }
}