package com.example.cobauas.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cobauas.Edukasi
import com.example.cobauas.EdukasiAdapter
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
            )
        )

        // 2️⃣ Set adapter
        val adapter = EdukasiAdapter(edukasiList)
        recycler.adapter = adapter

        // 3️⃣ Refresh UI
        adapter.notifyDataSetChanged()
    }

}
