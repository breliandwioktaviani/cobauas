package com.example.cobauas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class cekdetail : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_cekdetail)

            // Ambil data dari Intent
            val nama = intent.getStringExtra("nama")
            val service = intent.getStringExtra("service")
            val status = intent.getStringExtra("status")
            val nomor = intent.getStringExtra("nomor") ?: "AE 1922 SH" // contoh default

            // Hubungkan View
            val tvMerk = findViewById<TextView>(R.id.tvMerk)
            val tvJenis = findViewById<TextView>(R.id.tvJenis)
            val tvNomor = findViewById<TextView>(R.id.tvNomor)
            val tvTerakhir = findViewById<TextView>(R.id.tvTerakhir)
            val tvSelanjutnya = findViewById<TextView>(R.id.tvCatatan)
            val btnClose = findViewById<TextView>(R.id.btnClose)

            // Isi data
            tvMerk.text = "Honda"
            tvJenis.text = "Vario 125"
            tvNomor.text = "AE 1922 SH"
            tvTerakhir.text = "16/06/2025"
            tvSelanjutnya.text = "16/07/2025"

            btnClose.setOnClickListener {
                finish()
            }
        }
    }