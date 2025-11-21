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


 class MotorAdapter (val ListMotor: List<Motor>): RecyclerView.Adapter<MotorAdapter.MotorViewHolder>(){
    class MotorViewHolder(val row: View): RecyclerView.ViewHolder(row){
        val nama = row.findViewById<TextView>(R.id.nama)
        val service = row.findViewById<TextView>(R.id.service)
        val status = row.findViewById<TextView>(R.id.status)
        val btnMore = row.findViewById<ImageView>(R.id.btnMore)

    }
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): MotorViewHolder{
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
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
                         val context = holder.itemView.context
                         val intent = Intent(context, cekdetail::class.java)

                         intent.putExtra("merk", motor.merk)
                         intent.putExtra("jenis", motor.jenis)
                         intent.putExtra("nomor", motor.nomor)
                         intent.putExtra("terakhir", motor.terakhir)
                         intent.putExtra("selanjutnya", motor.selanjutnya)
                         intent.putExtra("status", motor.status.name)

                         context.startActivity(intent)
                         true
                     }
                     R.id.menu_edit -> {
                         true
                     }
                     R.id.menu_delete -> {
                         true
                     }
                     else -> false
                 }
             }
             popup.show()
         }
     }

     override fun getItemCount(): Int {
         return  ListMotor.size
     }
 }