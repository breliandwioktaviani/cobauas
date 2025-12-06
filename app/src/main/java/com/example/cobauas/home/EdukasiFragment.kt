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


        edukasiList.add(
            Edukasi(
                "Cara Merawat Motor",
                "Pastikan rutin mengganti oli setiap 2000 km dan cek tekanan ban."
            ),

        )
        edukasiList.add(
            Edukasi(
                "Tips servis Rutin",
                "Pastikan motor anda selalu dalam keadaan optimal"
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
