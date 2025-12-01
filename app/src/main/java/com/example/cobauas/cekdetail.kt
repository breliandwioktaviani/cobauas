package com.example.cobauas

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class cekdetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cekdetail)

        val merk = intent.getStringExtra("merk")
        val jenis = intent.getStringExtra("jenis")
        val nomor = intent.getStringExtra("nomor")
        val terakhir = intent.getStringExtra("terakhir")
        val selanjutnya = intent.getStringExtra("selanjutnya")
        val status = intent.getStringExtra("status")

        val tvMerk = findViewById<EditText>(R.id.tvMerk)
        val tvJenis = findViewById<EditText>(R.id.tvJenis)
        val tvNomor = findViewById<EditText>(R.id.tvNomor)
        val tvTerakhir = findViewById<EditText>(R.id.tvTerakhir)
        val tvSelanjutnya = findViewById<EditText>(R.id.tvSelanjutnya)

        tvMerk.setText(merk)
        tvJenis.setText(jenis)
        tvNomor.setText(nomor)
        tvTerakhir.setText(terakhir)
        tvSelanjutnya.setText(selanjutnya)


        val btnClose = findViewById<TextView>(R.id.btnClose)

        btnClose.setOnClickListener {
            finish()
        }

    }
}
