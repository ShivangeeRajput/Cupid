package com.example.cupid.ui.activity.Onboarding

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.cupid.R
import com.example.cupid.databinding.ActivitySignInBinding
import com.example.cupid.ui.activity.MainActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sign_in)
        initViews()
    }

    private fun initViews() {

        findViewById<AppCompatButton>(R.id.btnLogin).setOnClickListener {
            login()
        }
        findViewById<TextView>(R.id.forgotPassword).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun login() {

        val email = findViewById<TextInputEditText>(R.id.emailAddress).text.toString()
        val password = findViewById<TextInputEditText>(R.id.password).text.toString()
        if (email.isEmpty()) {
            findViewById<TextInputLayout>(R.id.emailAddress).error = "Email cannot be empty"
            return
        }
        if (password.isEmpty()) {
            findViewById<TextInputLayout>(R.id.password).error = "Password cannot be empty"
            return
        }
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE


        Handler(Looper.getMainLooper()).postDelayed({
            findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE


            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }
}
