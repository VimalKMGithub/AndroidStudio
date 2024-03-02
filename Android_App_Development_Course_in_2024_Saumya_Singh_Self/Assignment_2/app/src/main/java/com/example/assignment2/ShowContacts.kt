package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment2.databinding.ActivityShowContactsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShowContacts : AppCompatActivity() {
    private lateinit var bindShowContacts: ActivityShowContactsBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindShowContacts = ActivityShowContactsBinding.inflate(layoutInflater)
        setContentView(bindShowContacts.root)

        val userName = intent.getStringExtra("userName").toString()
        "User: $userName".also { bindShowContacts.tvShowContactsName.text = it }
        database =
            FirebaseDatabase.getInstance().getReference("Users").child(userName).child("contacts")

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val contactsList = mutableListOf<String>()

                for (contactSnapshot in snapshot.children) {
                    val contact = contactSnapshot.getValue(Contacts::class.java)
                    contact?.let {
                        val contactInfo = "Name: ${it.name}, Number: ${it.number}"
                        contactsList.add(contactInfo)
                    }
                }
                val contactsText = contactsList.joinToString("\n")
                bindShowContacts.tvContacts.text = contactsText
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ShowContacts, "Failed to retrieve contacts", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}