package com.example.quizpr

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizpr.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseFirestore
    private lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()
        dialog = ProgressDialog(this)
        dialog.setMessage("We're creating new account...")
        dialog.setCancelable(false)
        binding.createNewBtn.setOnClickListener {
            val email = binding.emailBox.text.toString().trim()
            val pass = binding.passwordBox.text.toString()
            val name = binding.nameBox.text.toString()
            val referCode = binding.referBox.text.toString()
            if (email.isEmpty() || pass.isEmpty() || name.isEmpty()) {
                Toast.makeText(
                    this@SignupActivity, "Must fill email, pass & name...", Toast.LENGTH_SHORT
                ).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(
                    this@SignupActivity, "Enter a valid email...", Toast.LENGTH_SHORT
                ).show()
            } else {
                val user = User(
                    name,
                    email,
                    "https://firebasestorage.googleapis.com/v0/b/quiz-5c7fb.appspot.com/o/avatar.png?alt=media&token=c4c1d3ed-541a-4d39-8e8a-9f005fae9ce2",
                    referCode
                )
                dialog.show()
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val uid = task.result?.user?.uid
                        uid?.let {
                            database.collection("users").document(it).set(user)
                                .addOnCompleteListener { dbTask ->
                                    if (dbTask.isSuccessful) {
                                        dialog.dismiss()
                                        startActivity(
                                            Intent(
                                                this@SignupActivity, MainActivity::class.java
                                            )
                                        )
                                        finish()
                                    } else {
                                        Toast.makeText(
                                            this@SignupActivity,
                                            dbTask.exception?.message,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    } else {
                        dialog.dismiss()
                        Toast.makeText(
                            this@SignupActivity, task.exception?.message, Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }
    }
}