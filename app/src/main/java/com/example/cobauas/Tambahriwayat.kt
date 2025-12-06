package com.example.cobauas

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cobauas.home.HomeActivity.Companion.globalPassword
import com.example.cobauas.home.HomeActivity.Companion.globalUsername
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Tambahriwayat : AppCompatActivity() {

    private lateinit var tvTerakhir: EditText
    private lateinit var tvSelanjutnya: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tambahriwayat)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        tvTerakhir = findViewById(R.id.tvTerakhir)
        tvSelanjutnya = findViewById(R.id.tvSelanjutnya)


        val welcomeUsername = findViewById<TextView>(R.id.tvName)
        welcomeUsername.text = globalUsername

        // === Tombol profile ===
        val buttonProfile = findViewById<ImageView>(R.id.imgProfile)
        buttonProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(Login.KEY_USERNAME, globalUsername)
            intent.putExtra(Login.KEY_PASSWORD, globalPassword)
            startActivity(intent)
        }

        // === Logout ===
        val logout = findViewById<ImageView>(R.id.Logout)
        logout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Tampilkan DatePicker saat klik EditText
        tvTerakhir.setOnClickListener { showDatePicker(tvTerakhir) }
        tvSelanjutnya.setOnClickListener { showDatePicker(tvSelanjutnya) }

        // === Input text lainnya ===
        val tvMerk = findViewById<EditText>(R.id.tvMerk)
        val tvJenis = findViewById<EditText>(R.id.tvJenis)
        val tvNomor = findViewById<EditText>(R.id.tvNomor)
        val tvCatatan = findViewById<EditText>(R.id.tvCatatan)

        // === Tombol kembali ===
        val btnKembali = findViewById<TextView>(R.id.btnKembali)
        btnKembali.setOnClickListener { finish() }

        // === Tombol simpan ===
        val btnSimpan = findViewById<TextView>(R.id.btnSimpan)
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
