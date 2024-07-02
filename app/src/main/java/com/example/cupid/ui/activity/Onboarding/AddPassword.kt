package com.example.cupid.ui.activity.Onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.cupid.R
import com.example.cupid.ui.activity.MainActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AddPassword : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_password)
        supportActionBar?.hide()

        val emailEditText: TextInputEditText = findViewById(R.id.emailAddress)
        val passwordEditText: TextInputEditText = findViewById(R.id.password)
        val agreeAndJoinButton :AppCompatButton = findViewById(R.id.agreeAndJoin)
        progressBar = findViewById(R.id.registerProgressBar)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")

        auth = FirebaseAuth.getInstance()

        agreeAndJoinButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                progressBar.visibility = View.VISIBLE
                registerUser(email, password, firstName, lastName)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(email: String, password: String, firstName: String?, lastName: String?) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                progressBar.visibility = View.GONE
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        saveUserProfile(user.uid, firstName!!, lastName!!, email)
                    }
                } else {
                    Toast.makeText(this, "Registration failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun saveUserProfile(userId: String, firstName: String, lastName: String, email: String) {
        val db = FirebaseFirestore.getInstance()
        val userProfile = hashMapOf(
            "firstName" to firstName,
            "lastName" to lastName,
            "email" to email
        )

        db.collection("users").document(userId).set(userProfile)
            .addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Profile save failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
