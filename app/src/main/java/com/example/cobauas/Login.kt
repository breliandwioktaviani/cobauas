package com.example.cobauas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)

        val button = findViewById<Button>(R.id.loginButton)

        button.setOnClickListener {
        val username = email.text.toString()
        val password = password.text.toString()
            if (username == "Adi" && password == "123") {

                val inten = Intent(this, MainActivity::class.java)
                startActivity(inten)
                Toast.makeText(this, "Login Berhasil" , Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show()

            }
        }
    }


}