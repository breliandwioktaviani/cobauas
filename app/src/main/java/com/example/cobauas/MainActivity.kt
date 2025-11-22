//package com.example.cobauas
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Intent
//import android.os.Build
//import android.os.Bundle
//import android.widget.Button
//import android.widget.ImageView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class MainActivity : AppCompatActivity() {
//
//    private val motorList = mutableListOf<Motor>()
//    private lateinit var recycler: RecyclerView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_home)
//        val intent = Intent(this, NotifReceiver::class.java).apply {
//            putExtra("judul", "Tes Notifikasi")
//            putExtra("pesan", "Awa Hytam")
//        }
//
//        sendBroadcast(intent)
//
//
//        buatChannel()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1)
//        }
//
//        recycler = findViewById(R.id.recycler)
//        recycler.layoutManager = LinearLayoutManager(this)
//        recycler.adapter = MotorAdapter(motorList)
//
//
//        val btnTambah = findViewById<ImageView>(R.id.fabAdd)
//        btnTambah.setOnClickListener {
//            val intent = Intent(this, Tambahriwayat::class.java)
//            startActivityForResult(intent, 1)
//        }
//
//
//        val btnBeranda = findViewById<Button>(R.id.btnBeranda)
//        val btnRiwayat = findViewById<Button>(R.id.btnRiwayat)
//
//        btnBeranda.setOnClickListener {
//            // kosong karena sudah di halaman ini
//        }
//
//        btnRiwayat.setOnClickListener {
//            val go = Intent(this, Riwayatt::class.java)
//            startActivity(go)
//        }
//
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//
//            val nama = data?.getStringExtra("nama") ?: ""
//            val tanggal = data?.getStringExtra("tanggal") ?: ""
//            val jenis = data?.getStringExtra("service") ?: ""
//            val nomor = data?.getStringExtra("nomor") ?: ""
//            val selanjutnya = data?.getStringExtra("selanjutnya") ?: ""
//
//            val statusMotor = if (data?.getStringExtra("status") == "selesai")
//                status.selesai
//            else
//                status.akan_datang
//
//            motorList.add(
//                Motor(
//                    merk = nama,
//                    jenis = jenis,
//                    nomor = nomor,
//                    terakhir = tanggal,
//                    selanjutnya = selanjutnya,
//                    status = statusMotor
//                )
//            )
//
//            recycler.adapter?.notifyDataSetChanged()
//        }
//    }
//
//
//    private fun buatChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                "service_channel",
//                "Pengingat Service Motor",
//                NotificationManager.IMPORTANCE_HIGH
//            )
//
//            val manager = getSystemService(NotificationManager::class.java)
//            manager.createNotificationChannel(channel)
//        }
//    }
//}
