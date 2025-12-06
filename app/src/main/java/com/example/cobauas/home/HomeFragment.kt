package com.example.cobauas.home
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
import com.example.cobauas.Tambahriwayat
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cobauas.*
import com.example.cobauas.R


class HomeFragment : Fragment() {

    private lateinit var adapter: MotorAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

         adapter = MotorAdapter(MotorData.motorList, "HOME")



        // Recycler
        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter


        val buttonProfilee = view.findViewById<ImageView>(R.id.imgProfile)
        buttonProfilee?.setOnClickListener {
            val username = HomeActivity.globalUsername
            val password = HomeActivity.globalPassword
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            intent.putExtra(Login.KEY_USERNAME, username)
            intent.putExtra(Login.KEY_PASSWORD, password)
            startActivity(intent)
        }


        val logout = view.findViewById<ImageView>(R.id.Logout)

        logout.setOnClickListener {
            val intent = Intent(requireContext(), Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        adapter.onEditClick = { motor, pos ->
            val intent = Intent(requireContext(), EditMotor::class.java)
            intent.putExtra("position", pos)
            intent.putExtra("merk", motor.merk)
            intent.putExtra("jenis", motor.jenis)
            intent.putExtra("nomor", motor.nomor)
            intent.putExtra("terakhir", motor.terakhir)
            intent.putExtra("selanjutnya", motor.selanjutnya)
            intent.putExtra("catatan", motor.catatan)

            startActivityForResult(intent, 2)
        }
        // Tombol Tambah
        val btnTambah = view.findViewById<ImageView>(R.id.fabAdd)
        btnTambah.setOnClickListener {
            val intent = Intent(requireContext(), Tambahriwayat::class.java)
            startActivityForResult(intent, 1)
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
                catatan = data?.getStringExtra("catatan") ?: "",
                status = if (data?.getStringExtra("status") == "selesai")
                    status.selesai else status.akan_datang
            )

            MotorData.motorList.add(motor)
            recycler.adapter?.notifyDataSetChanged()
        }



        if (requestCode == 2 && resultCode == Activity.RESULT_OK) {

            val pos = data?.getIntExtra("position", -1) ?: return

            if (pos != -1) {
                MotorData.motorList[pos].merk = data?.getStringExtra("merk") ?: ""
                MotorData.motorList[pos].jenis = data?.getStringExtra("jenis") ?: ""
                MotorData.motorList[pos].nomor = data?.getStringExtra("nomor") ?: ""
                MotorData.motorList[pos].terakhir = data?.getStringExtra("terakhir") ?: ""
                MotorData.motorList[pos].selanjutnya = data?.getStringExtra("selanjutnya") ?: ""
                MotorData.motorList[pos].catatan = data?.getStringExtra("catatan") ?: ""
            }

            adapter.notifyDataSetChanged()
        }

    }
    override fun onResume() {
        super.onResume()
        recycler.adapter?.notifyDataSetChanged()
    }

}
