package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment2.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var database:DatabaseReference
    private lateinit var bindSignUp: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindSignUp = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(bindSignUp.root)

        bindSignUp.btnSignUp.setOnClickListener {
            val name = bindSignUp.etName.text.toString()
            val mail = bindSignUp.etMail.text.toString()
            val userName = bindSignUp.etUserName.text.toString()
            val password = bindSignUp.etPassword.text.toString()

            if (name.isEmpty() || mail.isEmpty() || userName.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {

                val user = User(name, mail, password, userName)

                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(userName).setValue(user).addOnSuccessListener {
                    bindSignUp.etName.text?.clear()
                    bindSignUp.etMail.text?.clear()
                    bindSignUp.etUserName.text?.clear()
                    bindSignUp.etPassword.text?.clear()
                    Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,AddContacts::class.java).putExtra("userName",userName))
                    finishAffinity()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        bindSignUp.tvSignIn.setOnClickListener{
            startActivity(Intent(this,SignIn::class.java))
        }
    }
}