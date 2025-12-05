package com.example.cobauas

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class EditMotor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_motor)

        // === Ambil ID dari XML ===
        val edtMerk = findViewById<EditText>(R.id.edtMerk)
        val edtJenis = findViewById<EditText>(R.id.edtJenis)
        val edtNomor = findViewById<EditText>(R.id.edtNomor)
        val edtTerakhir = findViewById<EditText>(R.id.edtTerakhir)
        val edtSelanjutnya = findViewById<EditText>(R.id.edtSelanjutnya)
        val edtCatatan = findViewById<EditText>(R.id.edtCatatan)

        val btnSimpan = findViewById<TextView>(R.id.btnSimpan)
        val btnKembali = findViewById<TextView>(R.id.btnKembali)


        val pos = intent.getIntExtra("position", -1)

        // === SET DATA KE EDIT TEXT (BIAR SUDAH TERISI SAAT EDIT) ===
        edtMerk.setText(intent.getStringExtra("merk"))
        edtJenis.setText(intent.getStringExtra("jenis"))
        edtNomor.setText(intent.getStringExtra("nomor"))
        edtTerakhir.setText(intent.getStringExtra("terakhir"))
        edtSelanjutnya.setText(intent.getStringExtra("selanjutnya"))
        edtCatatan.setText(intent.getStringExtra("catatan"))

        // === DATE PICKER untuk tanggal terakhir dan selanjutnya ===
        edtTerakhir.setOnClickListener { showDatePicker(edtTerakhir) }
        edtSelanjutnya.setOnClickListener { showDatePicker(edtSelanjutnya) }

        // === Tombol kembali ===
        btnKembali.setOnClickListener { finish() }

        // === Tombol simpan ===
        btnSimpan.setOnClickListener {
            val result = Intent()
            result.putExtra("position", pos)
            result.putExtra("merk", edtMerk.text.toString())
            result.putExtra("jenis", edtJenis.text.toString())
            result.putExtra("nomor", edtNomor.text.toString())
            result.putExtra("terakhir", edtTerakhir.text.toString())
            result.putExtra("selanjutnya", edtSelanjutnya.text.toString())
            result.putExtra("catatan", edtCatatan.text.toString())

            setResult(RESULT_OK, result)
            finish()
        }
    }

    private fun showDatePicker(target: EditText) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dp = DatePickerDialog(this, { _, y, m, d ->
            target.setText("$d/${m+1}/$y")
        }, year, month, day)

        dp.show()
    }
}
