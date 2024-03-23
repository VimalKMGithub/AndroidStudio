package com.example.quizpr

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizpr.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var dialog: ProgressDialog
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        dialog = ProgressDialog(this)
        dialog.setMessage("Logging in...")
        dialog.setCancelable(false)
        if (auth.currentUser != null) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
        binding.submitBtn.setOnClickListener {
            val email = binding.emailBox.text.toString().trim()
            val pass = binding.passwordBox.text.toString()
            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(
                    this@LoginActivity, "Fill all fields...", Toast.LENGTH_SHORT
                ).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(
                    this@LoginActivity, "Enter a valid email...", Toast.LENGTH_SHORT
                ).show()
            } else {
                dialog.show()
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                    dialog.dismiss()
                    if (task.isSuccessful) {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this@LoginActivity, task.exception?.message, Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        binding.resetPasswd.setOnClickListener {
            val email = binding.emailBox.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(
                    this@LoginActivity, "Enter an email...", Toast.LENGTH_SHORT
                ).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(
                    this@LoginActivity, "Enter a valid email...", Toast.LENGTH_SHORT
                ).show()
            } else {
                firestore.collection("users").whereEqualTo("email", email).get()
                    .addOnSuccessListener { documents ->
                        if (!documents.isEmpty) {
                            auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(
                                        this@LoginActivity,
                                        "Password reset link sent...",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        this@LoginActivity,
                                        task.exception?.message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        } else {
                            dialog.dismiss()
                            Toast.makeText(
                                this@LoginActivity,
                                "Email not registered sign up...",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
        binding.createNewBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
            finish()
        }
    }
}