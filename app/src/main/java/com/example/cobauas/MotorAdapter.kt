package com.example.cobauas

import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.PopupMenu
import android.view.ContextThemeWrapper
import com.example.cobauas.home.RiwayatFragment


class MotorAdapter(
    val ListMotor: MutableList<Motor>,

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
        holder.status.text = motor.status.name

        if (motor.status == status.akan_datang) {
            holder.status.text = "akan datang"
        } else {
            holder.status.text = "selesai"
        }

        holder.btnMore.setOnClickListener { view ->
            val wrapper = ContextThemeWrapper(view.context, R.style.MyPopupMenuStyle)
            val popup = PopupMenu(wrapper, view)

            popup.menuInflater.inflate(R.menu.menu_motor, popup.menu)

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_detail -> {
                        motor.status = status.selesai
                        MotorData.motorRiwayat.add(motor)
                        ListMotor.removeAt(position)
                        notifyItemRemoved(position)
                        true
                    }

                    R.id.menu_edit -> {
                        true
                    }

                    R.id.menu_delete -> {
                        ListMotor.removeAt(position)
                        true
                    }

                    else -> false
                }
            }
            popup.show()
        }
    }

    override fun getItemCount(): Int {
        return ListMotor.size
    }
}