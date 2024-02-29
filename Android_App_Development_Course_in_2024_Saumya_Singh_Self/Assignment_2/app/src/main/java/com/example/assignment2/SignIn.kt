package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment2.databinding.ActivitySignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {
    private lateinit var bindingSignIn: ActivitySignInBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSignIn = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(bindingSignIn.root)

        bindingSignIn.btnSignIn.setOnClickListener {
            val userName = bindingSignIn.etUserNameSignIn.text.toString()
            if (userName.isEmpty()) {
                Toast.makeText(this, "Please enter User Name", Toast.LENGTH_SHORT).show()
            } else {
                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(userName).get().addOnSuccessListener {
                    if (it.exists()) {
                        Toast.makeText(this, "Sign In Successful", Toast.LENGTH_SHORT).show()
                        startActivity(
                            Intent(this, AddContacts::class.java).putExtra(
                                "userName",
                                userName
                            )
                        )
                        finishAffinity()
                    } else {
                        Toast.makeText(
                            this,
                            "User does not exist, Please sign Up",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        bindingSignIn.tvSignUp.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
            finishAffinity()
        }
    }
}