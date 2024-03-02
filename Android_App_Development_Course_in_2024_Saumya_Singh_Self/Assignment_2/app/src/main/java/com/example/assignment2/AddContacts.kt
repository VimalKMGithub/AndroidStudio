package com.example.assignment2

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.example.assignment2.databinding.ActivityAddContactsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddContacts : AppCompatActivity() {
    private lateinit var bindAddContacts: ActivityAddContactsBinding
    private lateinit var database: DatabaseReference
    private lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindAddContacts = ActivityAddContactsBinding.inflate(layoutInflater)
        setContentView(bindAddContacts.root)

        val userName = intent.getStringExtra("userName").toString()
        "User: $userName".also { bindAddContacts.tvAddContacts.text = it }

        dialog = Dialog(this)
        dialog.setContentView(R.layout.contact_added)
        dialog.window?.setBackgroundDrawable(
            AppCompatResources.getDrawable(
                this,
                R.drawable.bg_alert
            )
        )

        bindAddContacts.add.setOnClickListener {
            val name = bindAddContacts.etContactName.text.toString()
            val number = bindAddContacts.etContactNumber.text.toString()

            if (name.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val contacts = Contacts(name, number)
                database = FirebaseDatabase.getInstance().getReference("Users").child(userName)
                    .child("contacts")
                val newContactRef = database.push()
                newContactRef.setValue(contacts).addOnSuccessListener {
                    bindAddContacts.etContactName.text?.clear()
                    bindAddContacts.etContactNumber.text?.clear()
                    dialog.show()
                    val btnOk = dialog.findViewById<Button>(R.id.btnOk)
                    btnOk?.setOnClickListener {
                        dialog.dismiss()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }



        bindAddContacts.tvShowContacts.setOnClickListener {
            startActivity(Intent(this, ShowContacts::class.java).putExtra("userName", userName))
        }
    }
}