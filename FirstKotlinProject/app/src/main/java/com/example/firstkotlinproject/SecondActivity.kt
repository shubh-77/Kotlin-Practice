package com.example.firstkotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        1st way
//        var username=intent.getStringExtra("username")
//        var pass=intent.getStringExtra("pass")
//        textView.text="Received data from user:\n USERNAME:$username\n PASSWORD:$pass"


//        2nd way
        var username= intent.extras?.getString("username")
        var pass=intent.extras?.getString("pass")
        var gender=intent.extras?.getString("gender")
        var vehicle=intent.extras?.getString("vehicle")
        var choice=intent.extras?.getString("choice")
        val v=vehicle.toString()
        val v1=v.trim()
        textView.text="Received data from user:\n USERNAME:$username\n PASSWORD:$pass\n GENDER:$gender\n Vehicle:$v1 \nChoice:$choice"



        button2.setOnClickListener{
            var i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        button3.setOnClickListener{
            var i=Intent(this,ThirdActivity::class.java)
            startActivity(i)
        }
    }
}