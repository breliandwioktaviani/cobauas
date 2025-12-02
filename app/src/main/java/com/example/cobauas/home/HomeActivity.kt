package com.example.cobauas.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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
        val username = intent.getStringExtra(Login.Username)
        val password = intent.getStringExtra(Login.Password)
        val navController = findNavController(R.id.fragmentContainerView)


        val bundle = Bundle()
        bundle.putString("username",username)
        bundle.putString("password",password)

        navController.setGraph(R.navigation.nav_home,bundle)

        val buttonProfile = findViewById<ImageView>(R.id.imgProfile)

        buttonProfile.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(Login.Username,username)
            intent.putExtra(Login.Password,password)
            startActivity(intent)
        }
        buttonNavigationView.setupWithNavController(navController )
    }


    companion object {
        val semuaMotor = mutableListOf<Motor>()
    }



}