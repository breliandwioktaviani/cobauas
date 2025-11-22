//package com.example.cobauas
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Intent
//import android.os.Build
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.constraintlayout.motion.widget.MotionLayout
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class Splash : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_splash)
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val name = "Service Reminder Channel"
//            val desc = "Channel untuk pengingat servis motor"
//            val importance = NotificationManager.IMPORTANCE_HIGH
//
//            val channel = NotificationChannel("service_channel", name, importance)
//            channel.description = desc
//
//            val manager = getSystemService(NotificationManager::class.java)
//            manager.createNotificationChannel(channel)
//        }
//        // ================================================
//
//        val motionLayout = findViewById<MotionLayout>(R.id.main)
//
//        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
//            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
//                startActivity(Intent(this@Splash, Login::class.java))
//                finish()
//            }
//            override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {}
//            override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {}
//            override fun onTransitionTrigger(motionLayout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {}
//        })
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}
