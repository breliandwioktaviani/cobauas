package com.example.cobauas.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cobauas.Login
import com.example.cobauas.Motor
import com.example.cobauas.ProfileActivity
import com.example.cobauas.R

import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        globalUsername = intent.getStringExtra(Login.KEY_USERNAME)
        globalPassword = intent.getStringExtra(Login.KEY_PASSWORD)

        val navController = findNavController(R.id.fragmentContainerView)



        val bundle = Bundle().apply {
            putString("username", globalUsername)
            putString("password", globalPassword)
        }
        navController.setGraph(R.navigation.nav_home, bundle)

        // Bottom Nav
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setupWithNavController(navController)

        val buttonProfile = findViewById<ImageView>(R.id.imgProfile)

        buttonProfile.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(Login.KEY_USERNAME, globalUsername)
            intent.putExtra(Login.KEY_PASSWORD, globalPassword)
            startActivity(intent)
        }
        buttonNavigationView.setupWithNavController(navController )
    }

    companion object {
        var globalUsername: String? = null
        var globalPassword: String? = null
    }


}