package com.example.secondkotlinproject

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    lateinit var mp:MediaPlayer
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")

    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this,"Service Created",Toast.LENGTH_SHORT).show()

        mp=MediaPlayer.create(this,R.raw.abc)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show()
            mp.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_SHORT).show()
        mp.stop()
    }


}