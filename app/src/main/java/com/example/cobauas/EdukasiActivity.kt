package com.example.cobauas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cobauas.databinding.ActivityEdukasiBinding

class EdukasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edukasi)
        val btnTutup = findViewById<Button>(R.id.TutupBuuton)

        btnTutup.setOnClickListener {
            finish()
        }
        }
    }

