package com.example.cobauas

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

 class MotorAdapter (val ListMotor: List<Motor>): RecyclerView.Adapter<MotorAdapter.MotorViewHolder>(){
    class MotorViewHolder(val row: View): RecyclerView.ViewHolder(row){
        val nama = row.findViewById<TextView>(R.id.nama)
        val service = row.findViewById<TextView>(R.id.service)
        val status = row.findViewById<TextView>(R.id.status)
    }
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): MotorViewHolder{
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        return MotorViewHolder(layout)
    }

     override fun onBindViewHolder(holder: MotorViewHolder, position: Int) {
         val motor = ListMotor[position]
         holder.nama.text = motor.nama
         holder.service.text = motor.service
         holder.status.text = motor.status.name

         if (motor.status == status.akan_datang) {
             holder.status.text = "akan datang"
         } else {
             holder.status.text = "selesai"
         }


     }

     override fun getItemCount(): Int {
         return  ListMotor.size
     }


 }