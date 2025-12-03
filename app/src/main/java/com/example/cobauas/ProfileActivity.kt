package com.example.cobauas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usernameProfile = findViewById<TextView>(R.id.usernameProfile)
        val passwordProfile = findViewById<TextView>(R.id.passwordProfile)

        val buttonBack = findViewById<TextView>(R.id.back)
        buttonBack.setOnClickListener{
            finish()
        }
        val username = intent.getStringExtra(Login.Username)
        val password = intent.getStringExtra(Login.Password)

        usernameProfile.text = username
        passwordProfile.text = password
    }
}