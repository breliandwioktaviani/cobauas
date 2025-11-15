package com.example.cobauas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val motorList = mutableListOf<Motor>()
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)

        // Tidak ada getMotor()
        recycler.adapter = MotorAdapter(motorList)

        val btnTambah = findViewById<ImageView>(R.id.fabAdd)
        btnTambah.setOnClickListener {
            val intent = Intent(this, tambahriwayat::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {

            val nama = data?.getStringExtra("nama") ?: ""
            val tanggal = data?.getStringExtra("tanggal") ?: ""
            val jenis = data?.getStringExtra("service") ?: ""
            val nomor = data?.getStringExtra("nomor") ?: ""
            val selanjutnya = data?.getStringExtra("selanjutnya") ?: ""


            val statusMotor = if (data?.getStringExtra("status") == "selesai") status.selesai else status.akan_datang

            motorList.add(
                Motor(
                    merk = nama,
                    jenis = jenis,
                    nomor = nomor,
                    terakhir = tanggal,
                    selanjutnya = selanjutnya,
                    status = statusMotor
                )
            )

            recycler.adapter?.notifyDataSetChanged()
        }
    }
}
