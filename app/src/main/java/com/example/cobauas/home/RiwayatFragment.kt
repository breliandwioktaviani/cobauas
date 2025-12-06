package com.example.cobauas.home

import android.content.Intent
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

        val riwayatList = MotorData.motorRiwayat
        motorAdapter = MotorAdapter(riwayatList,"RIWAYAT")
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = motorAdapter


    }
}
