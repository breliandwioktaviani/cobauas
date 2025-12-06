package com.example.cobauas

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cobauas.home.HomeActivity.Companion.globalPassword
import com.example.cobauas.home.HomeActivity.Companion.globalUsername

class cekdetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cekdetail)


        val buttonProfile = findViewById<ImageView>(R.id.imgProfile)

        val welcomeUsername = findViewById<TextView>(R.id.tvName)
        welcomeUsername.text = globalUsername

        buttonProfile.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(Login.KEY_USERNAME, globalUsername)
            intent.putExtra(Login.KEY_PASSWORD, globalPassword)
            startActivity(intent)
        }

        val logout = findViewById<ImageView>(R.id.Logout)

        logout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


        val merk = intent.getStringExtra("merk")
        val jenis = intent.getStringExtra("jenis")
        val nomor = intent.getStringExtra("nomor")
        val terakhir = intent.getStringExtra("terakhir")
        val selanjutnya = intent.getStringExtra("selanjutnya")
        val catatan = intent.getStringExtra("catatan")

        val tvMerk = findViewById<EditText>(R.id.tvMerk)
        val tvJenis = findViewById<EditText>(R.id.tvJenis)
        val tvNomor = findViewById<EditText>(R.id.tvNomor)
        val tvTerakhir = findViewById<EditText>(R.id.tvTerakhir)
        val tvSelanjutnya = findViewById<EditText>(R.id.tvSelanjutnya)
        val tvCatatan = findViewById<EditText>(R.id.tvCatatan)
        tvMerk.setText(merk)
        tvJenis.setText(jenis)
        tvNomor.setText(nomor)
        tvTerakhir.setText(terakhir)
        tvSelanjutnya.setText(selanjutnya)
        tvCatatan.setText(catatan)


        val btnClose = findViewById<TextView>(R.id.btnClose)

        btnClose.setOnClickListener {
            finish()
        }

    }
}
