package com.example.cupid.ui.activity.Onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.cupid.R
import com.google.android.material.textfield.TextInputEditText

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sign_up)
        val firstNameEditText: TextInputEditText = findViewById(R.id.firstName)
        val lastNameEditText: TextInputEditText = findViewById(R.id.secondName)
        val nextButton: AppCompatButton = findViewById(R.id.next)

        nextButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()

            val intent = Intent(this, AddEmail::class.java).apply {
                putExtra("firstName", firstName)
                putExtra("lastName", lastName)
            }
            startActivity(intent)
        }
    }
    }

