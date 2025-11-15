package com.example.cobauas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var username = intent.getStringExtra(Login.Username)
        val textUsername = findViewById<TextView>(R.id.tvName)
        textUsername.text = username

        val recylerView = findViewById<RecyclerView>(R.id.recycler)

        val btnTambah = findViewById<ImageView>(R.id.fabAdd)
        btnTambah.setOnClickListener {
            val intent  = Intent (this, tambahriwayat::class.java)
            startActivity(intent)
        }

        recylerView.layoutManager = LinearLayoutManager(this)
        recylerView.adapter = MotorAdapter(getMotor())

    }

    fun getMotor(): List<Motor>{

        return listOf(
            Motor("Vario","13 november", status.akan_datang),
            Motor("Supra","13 november", status.selesai),
            Motor("Supra","13 november", status.selesai),
            Motor("Supra","13 november", status.selesai),
            Motor("Supra","13 november", status.selesai),
            Motor("Supra","13 november", status.selesai)
        )
    }
}