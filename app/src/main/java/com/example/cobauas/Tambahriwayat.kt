package com.example.cobauas
import com.example.cobauas.Tambahriwayat
import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class Tambahriwayat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tambahriwayat)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvTerakhir = findViewById<EditText>(R.id.tvTerakhir)

        tvTerakhir.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, y, m, d ->
                    val tanggal = String.format("%02d/%02d/%04d", d, m + 1, y)
                    tvTerakhir.setText(tanggal)
                },
                year,
                month,
                day
            )
            datePicker.show()
        }
        val tvSelanjutnya = findViewById<EditText>(R.id.tvSelanjutnya)

        tvSelanjutnya.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, y, m, d ->
                    val tanggal = String.format("%02d/%02d/%04d", d, m + 1, y)
                    tvSelanjutnya.setText(tanggal)
                },
                year,
                month,
                day
            )
            datePicker.show()
        }

        // Gunakan EditText (penting!)
        val tvMerk = findViewById<EditText>(R.id.tvMerk)
        val tvJenis = findViewById<EditText>(R.id.tvJenis)
        val tvNomor = findViewById<EditText>(R.id.tvNomor)

        val tvCatatan = findViewById<EditText>(R.id.tvCatatan)

        val btnKembali = findViewById<TextView>(R.id.btnKembali)
        val btnSimpan = findViewById<TextView>(R.id.btnSimpan)

        btnKembali.setOnClickListener {
            finish()
        }
        btnSimpan.setOnClickListener {
            try {
                val tanggal = tvSelanjutnya.text.toString() // format dd/MM/yyyy
                val parts = tanggal.split("/")

                val day = parts[0].toInt()
                val month = parts[1].toInt() - 1
                val year = parts[2].toInt()

                val calendar = Calendar.getInstance()
                calendar.set(year, month, day, 13, 6, 0)  // notif jam 09:00

                val triggerTime = calendar.timeInMillis

                val notifIntent = Intent(this, NotifReceiver::class.java)
                notifIntent.putExtra("judul", "Waktunya Servis Motor!")
                notifIntent.putExtra("pesan", "Servis: ${tvJenis.text}")

                val pendingIntent = PendingIntent.getBroadcast(
                    this,
                    1001,
                    notifIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )

                val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    triggerTime,
                    pendingIntent
                )

            } catch (e: Exception) {
                e.printStackTrace() // jika notif error, aplikasi tetap lanjut
            }


            val intent = Intent()
            intent.putExtra("nama", tvMerk.text.toString())
            intent.putExtra("tanggal", tvTerakhir.text.toString())
            intent.putExtra("service", tvJenis.text.toString())
            intent.putExtra("nomor", tvNomor.text.toString())
            intent.putExtra("selanjutnya", tvSelanjutnya.text.toString())
            intent.putExtra("catatan", tvCatatan.text.toString())

            setResult(RESULT_OK, intent)
            finish()
        }



    }
}
