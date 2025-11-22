package com.example.cobauas

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotifReceiver : BroadcastReceiver() {
    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun onReceive(context: Context, intent: Intent) {

        val judul = intent.getStringExtra("judul") ?: "Pengingat Servis"
        val pesan = intent.getStringExtra("pesan") ?: "Jangan lupa servis motor"

        val builder = NotificationCompat.Builder(context, "service_channel")
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle(judul)
            .setContentText(pesan)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        val manager = NotificationManagerCompat.from(context)
        manager.notify(2001, builder.build())
    }
}
