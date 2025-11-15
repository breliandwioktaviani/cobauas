package com.example.cobauas.home
import com.example.cobauas.Tambahriwayat
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cobauas.*
import com.example.cobauas.R

class HomeFragment : Fragment() {

    private val motorList = mutableListOf<Motor>()
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // NOTIF
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "service_channel",
                "Pengingat Service Motor",
                NotificationManager.IMPORTANCE_HIGH
            )

            val manager = requireContext().getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireActivity().requestPermissions(
                arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1
            )
        }

        // Recycler
        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = MotorAdapter(motorList)

        // Tombol Tambah
        val btnTambah = view.findViewById<ImageView>(R.id.fabAdd)
        btnTambah.setOnClickListener {
            val intent = Intent(requireContext(), Tambahriwayat::class.java)
            startActivityForResult(intent, 1)
        }

        // Tombol Riwayat
        view.findViewById<Button>(R.id.btnRiwayat).setOnClickListener {
            val go = Intent(requireContext(), Riwayatt::class.java)
            startActivity(go)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {

            val motor = Motor(
                merk = data?.getStringExtra("nama") ?: "",
                jenis = data?.getStringExtra("service") ?: "",
                nomor = data?.getStringExtra("nomor") ?: "",
                terakhir = data?.getStringExtra("tanggal") ?: "",
                selanjutnya = data?.getStringExtra("selanjutnya") ?: "",
                status = if (data?.getStringExtra("status") == "selesai")
                    status.selesai else status.akan_datang
            )

            motorList.add(motor)
            recycler.adapter?.notifyDataSetChanged()
        }
    }
}
