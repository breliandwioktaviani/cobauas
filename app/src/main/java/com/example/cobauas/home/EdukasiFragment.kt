package com.example.cobauas.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cobauas.Edukasi
import com.example.cobauas.EdukasiAdapter
import com.example.cobauas.Login
import com.example.cobauas.ProfileActivity
import com.example.cobauas.R

class EdukasiFragment : Fragment() {

    private val edukasiList = mutableListOf<Edukasi>()
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edukasi, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recyclerEdukasi)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        val logout = view.findViewById<ImageView>(R.id.Logout)

        logout.setOnClickListener {
            val intent = Intent(requireContext(), Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


        edukasiList.add(
            Edukasi(
                "Cara Merawat Motor",
                "Pastikan rutin mengganti oli setiap 2000 km dan cek tekanan ban.",
                        "1. Siapkan peralatan: oli baru sesuai rekomendasi, kunci ring/sok, wadah oli bekas, lap, corong.\n" +
                        "2. Panaskan mesin 2–3 menit agar oli lebih encer.\n" +
                        "3. Matikan mesin, pastikan motor berdiri tegak dengan stand tengah\n"+
                        "4. Buka tutup pengisian oli di atas mesin. \n"+
                        "5. Buka baut pembuangan oli, biarkan oli mengalir habis ke wadah penampung.\n" +
                        "6. Bersihkan dan pasang kembali baut pembuangan dengan kencang.\n" +
                        "7. Tuang oli baru sesuai kapasitas mesin.\n" +
                        "8. Hidupkan mesin sebentar, lalu matikan dan cek level oli.\n" +
                        "9. Ganti oli rutin 2.000–3.000 km.\n" +
                        "10. Jangan mencampur oli berbeda viskositas.\n" +
                        "11. Buang oli bekas di tempat yang menerima limbah oli.\n"
            ),

        )
        edukasiList.add(
            Edukasi(
                "Tips servis Rutin",
                "Pastikan motor anda selalu dalam keadaan optimal" ,

                        "1. Cek oli mesin, air radiator, dan tekanan ban.\n" +
                        "2. Ganti oli dan filter agar mesin tetap halus\n" +
                        "3. Periksa sistem rem: kampas, minyak rem, dan cakram.\n" +
                        "4. Cek kelistrikan: aki, lampu, dan kabel.\n" +
                        "5. Lakukan uji jalan untuk memastikan semuanya normal\n"
            )

        )

        // 2️⃣ Set adapter
        val adapter = EdukasiAdapter(edukasiList)
        recycler.adapter = adapter

        // 3️⃣ Refresh UI
        adapter.notifyDataSetChanged()
        val buttonProfilee = view.findViewById<ImageView>(R.id.imgProfile)
        buttonProfilee?.setOnClickListener {
            val username = HomeActivity.globalUsername
            val password = HomeActivity.globalPassword
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            intent.putExtra(Login.KEY_USERNAME, username)
            intent.putExtra(Login.KEY_PASSWORD, password)
            startActivity(intent)
        }


    }

}
