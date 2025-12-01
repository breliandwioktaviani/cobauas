package com.example.cobauas

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class Tambahriwayat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tambahriwayat)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvTerakhir = findViewById<EditText>(R.id.tvTerakhir)
        val tvSelanjutnya = findViewById<EditText>(R.id.tvSelanjutnya)

        fun showDatePicker(edit: EditText) {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(
                this,
                { _, y, m, d ->
                    val tgl = String.format("%02d/%02d/%04d", d, m + 1, y)
                    edit.setText(tgl)
                },
                year, month, day
            ).show()
        }

        tvTerakhir.setOnClickListener { showDatePicker(tvTerakhir) }
        tvSelanjutnya.setOnClickListener { showDatePicker(tvSelanjutnya) }

        val tvMerk = findViewById<EditText>(R.id.tvMerk)
        val tvJenis = findViewById<EditText>(R.id.tvJenis)
        val tvNomor = findViewById<EditText>(R.id.tvNomor)
        val tvCatatan = findViewById<EditText>(R.id.tvCatatan)

        val btnKembali = findViewById<TextView>(R.id.btnKembali)
        val btnSimpan = findViewById<TextView>(R.id.btnSimpan)

        btnKembali.setOnClickListener { finish() }

        btnSimpan.setOnClickListener {


            val intent = Intent()
            intent.putExtra("nama", tvMerk.text.toString())
            intent.putExtra("tanggal", tvTerakhir.text.toString())
            intent.putExtra("service", tvJenis.text.toString())
            intent.putExtra("nomor", tvNomor.text.toString())
            intent.putExtra("selanjutnya", tvSelanjutnya.text.toString())
            intent.putExtra("catatan", tvCatatan.text.toString())

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
