package com.example.cobauas

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

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

    fun showDatePicker(targetEditText: EditText) {
        val calendar = Calendar.getInstance()

        val datePicker = DatePickerDialog(
            this,
            { _, year, month, day ->
                val cal = Calendar.getInstance()
                cal.set(year, month, day)

                val format = SimpleDateFormat("dd MMM yyyy", Locale("id", "ID"))
                val dateString = format.format(cal.time)

                targetEditText.setText(dateString)

                Toast.makeText(this, "$dateString dipilih", Toast.LENGTH_SHORT).show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePicker.show()
    }
}
