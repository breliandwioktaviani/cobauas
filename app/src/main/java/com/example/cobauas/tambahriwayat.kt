package com.example.cobauas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class tambahriwayat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tambahriwayat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data dari Intent
        val nama = intent.getStringExtra("nama")
        val service = intent.getStringExtra("service")
        val status = intent.getStringExtra("status")
        val nomor = intent.getStringExtra("nomor") ?: "AE 1922 SH"
        val Catatan = intent.getStringExtra("Catatan")

        // Hubungkan View
        val tvMerk = findViewById<TextView>(R.id.tvMerk)
        val tvJenis = findViewById<TextView>(R.id.tvJenis)
        val tvNomor = findViewById<TextView>(R.id.tvNomor)
        val tvTerakhir = findViewById<TextView>(R.id.tvTerakhir)
        val tvSelanjutnya = findViewById<TextView>(R.id.tvSelanjutnya)
        val tvCatatan = findViewById<TextView>(R.id.tvCatatan)
        val btnKembali = findViewById<TextView>(R.id.btnKembali)
        val btnSimpan = findViewById<TextView>(R.id.btnSimpan)

        // Isi data
        tvMerk.text = "Honda"
        tvJenis.text = "Vario 125"
        tvNomor.text = "AE 1922 SH"
        tvTerakhir.text = "16/06/2025"
        tvSelanjutnya.text = "16/07/2025"
        tvCatatan.text = "Hari ini saya ganti oli dan kampas rem"

        btnKembali.setOnClickListener {
            finish()
        }

        btnSimpan.setOnClickListener {
            finish()
        }
    }
}