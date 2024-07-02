package com.example.cupid.ui.activity.Onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.cupid.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton

class AddEmail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_email)
        supportActionBar?.hide()
        val nextButton: AppCompatButton = findViewById(R.id.next)
        val emailEditText: TextInputEditText = findViewById(R.id.emailAddress)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")

        nextButton.setOnClickListener {
            val email = emailEditText.text.toString()

            val intent = Intent(this, AddPassword::class.java).apply {
                putExtra("firstName", firstName)
                putExtra("lastName", lastName)
                putExtra("email", email)
            }
            startActivity(intent)
        }
    }
}
