package com.example.cobauas
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EdukasiAdapter(
    private val listEdukasi: List<Edukasi>
) : RecyclerView.Adapter<EdukasiAdapter.EdukasiViewHolder>() {

    class EdukasiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val judul: TextView = itemView.findViewById(R.id.judul)
        val deskripsi: TextView = itemView.findViewById(R.id.deskripsi)
        val buttonKlik:ImageView = itemView.findViewById(R.id.btnMore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EdukasiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.edukasi_data, parent, false)
        return EdukasiViewHolder(view)
    }

    override fun onBindViewHolder(holder: EdukasiViewHolder, position: Int) {
        val data = listEdukasi[position]

        holder.judul.text = data.judul
        holder.deskripsi.text = data.deskripsi

        holder.buttonKlik.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, EdukasiActivity::class.java)
            intent.putExtra("judul", data.judul)
            intent.putExtra("detail", data.detail)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listEdukasi.size
}
