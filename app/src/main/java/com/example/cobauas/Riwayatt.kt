package com.example.cobauas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cobauas.home.HomeActivity


class Riwayatt : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var motorAdapter: MotorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayatt)

        recyclerView = findViewById(R.id.recycler)


        val btnBeranda: Button = findViewById(R.id.btnBeranda)
        val btnRiwayatt: Button = findViewById(R.id.btnRiwayat)
        val btnEdukasi: Button = findViewById(R.id.btnEdukasi)

        // 🔥 Ambil data username dari intent supaya tidak hilang

        // Dummy data ---> nanti bisa ganti database
        val listMotor = listOf(
            Motor("Honda", "Motor Scoopy", "B 1234 ABC", "22 Okt 2024", "22 Nov 2024", status.selesai),
            Motor("Yamaha", "Aerox", "B 8874 RST", "01 Mei 2024", "01 Jun 2024", status.akan_datang),
            Motor("Honda", "Beat", "B 7432 TYU", "11 April 2024", "11 Mei 2024", status.selesai)
        )

        // Filter hanya motor yang sudah selesai servis
        val riwayatList = listMotor.filter { it.status == status.selesai }

        motorAdapter = MotorAdapter(riwayatList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = motorAdapter


        btnBeranda.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }




    }
}