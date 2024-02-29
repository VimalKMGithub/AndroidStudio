package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment2.databinding.ActivityAddContactsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddContacts : AppCompatActivity() {
    private lateinit var bindAddContacts: ActivityAddContactsBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindAddContacts = ActivityAddContactsBinding.inflate(layoutInflater)
        setContentView(bindAddContacts.root)

        bindAddContacts.add.setOnClickListener {
            val name = bindAddContacts.etContactName.text.toString()
            val number = bindAddContacts.etContactNumber.text.toString()

            if (name.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val contacts = Contacts(name, number)
                val userName = intent.getStringExtra("userName").toString()
                database = FirebaseDatabase.getInstance().getReference("Users").child(userName)
                    .child("contacts")
                val newContactRef = database.push()
                newContactRef.setValue(contacts).addOnSuccessListener {
                    bindAddContacts.etContactName.text?.clear()
                    bindAddContacts.etContactNumber.text?.clear()
                    Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}