package com.example.cobauas.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cobauas.*

class RiwayatFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var motorAdapter: MotorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate layout
        return inflater.inflate(R.layout.fragment_riwayat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler)

        val btnBeranda: Button = view.findViewById(R.id.btnBeranda)
        val btnRiwayatt: Button = view.findViewById(R.id.btnRiwayat)
        val btnEdukasi: Button = view.findViewById(R.id.btnEdukasi)




        val riwayatList = MotorData.motorRiwayat
        motorAdapter = MotorAdapter(riwayatList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = motorAdapter

        btnBeranda.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
        }
    }
}
