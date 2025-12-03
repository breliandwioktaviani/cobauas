package com.example.cobauas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.view.ContextThemeWrapper
import androidx.recyclerview.widget.RecyclerView

class MotorAdapter(
    val ListMotor: MutableList<Motor>,
    val pageType: String
) : RecyclerView.Adapter<MotorAdapter.MotorViewHolder>() {

    class MotorViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val nama = row.findViewById<TextView>(R.id.nama)
        val service = row.findViewById<TextView>(R.id.service)
        val status = row.findViewById<TextView>(R.id.status)
        val btnMore = row.findViewById<ImageView>(R.id.btnMore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotorViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MotorViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MotorViewHolder, position: Int) {
        val motor = ListMotor[position]

        holder.nama.text = motor.jenis
        holder.service.text = motor.selanjutnya
        holder.status.text = if (motor.status == status.akan_datang) "akan datang" else "selesai"

        holder.btnMore.setOnClickListener { view ->
            val wrapper = ContextThemeWrapper(view.context, R.style.MyPopupMenuStyle)
            val popup = PopupMenu(wrapper, view)

            // MENU SESUAI HALAMAN
            if (pageType == "HOME") {
                popup.menuInflater.inflate(R.menu.menu_motor, popup.menu)
            } else {
                popup.menuInflater.inflate(R.menu.menu_riwayat, popup.menu)
            }

            // AKSI MENU
            popup.setOnMenuItemClickListener { item ->
                if (pageType == "HOME") {

                    when (item.itemId) {
                        R.id.menu_detail -> {
                            motor.status = status.selesai
                            MotorData.motorRiwayat.add(motor)
                            ListMotor.removeAt(position)
                            notifyItemRemoved(position)
                            true
                        }

                        R.id.menu_edit -> true

                        R.id.menu_delete -> {
                            ListMotor.removeAt(position)
                            notifyItemRemoved(position)
                            notifyItemRangeChanged(position, ListMotor.size)
                            true
                        }

                        else -> false
                    }

                } else {  // RIWAYATx
                    when (item.itemId) {
                        R.id.detailMenu -> {
                            val intent = Intent(holder.itemView.context, cekdetail::class.java)
                            intent.putExtra("merk",motor.merk)
                            intent.putExtra("jenis", motor.jenis)
                            intent.putExtra("nomor", motor.nomor)
                            intent.putExtra("terakhir", motor.terakhir)
                            intent.putExtra("selanjutnya", motor.selanjutnya)
                            intent.putExtra("status", motor.status)
                            holder.itemView.context.startActivity(intent)
                            true
                        }

                        R.id.hapus -> {
                            ListMotor.removeAt(position)
                            notifyItemRemoved(position)
                            notifyItemRangeChanged(position, ListMotor.size)
                            true
                        }

                        else -> false
                    }
                }
            }

            popup.show()
        }
    }

    override fun getItemCount(): Int = ListMotor.size
}
