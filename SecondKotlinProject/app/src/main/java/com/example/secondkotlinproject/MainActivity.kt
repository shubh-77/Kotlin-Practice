package com.example.secondkotlinproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var sp:SharedPreferences
    lateinit var remCreds:CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        remCreds=findViewById(R.id.checkBox1)






        sp=getSharedPreferences("myfile", MODE_PRIVATE)
        editTextUsername.setText(sp.getString("keyusername",""))
        editTextTextPassword.setText(sp.getString("keypassword",""))


//        var rs=20/0

//        checkBox1.setOnClickListener{
//            if(remCreds.isChecked){
//                sp=getSharedPreferences("myfile", MODE_PRIVATE)
//                editTextUsername.setText(sp.getString("keyusername",""))
//
//            }
//            else{
//                editTextUsername.setText("")
//
//            }
//        }




        buttonStart.setOnClickListener{
            var myIntent=Intent(this,MyService::class.java)
            startService(myIntent)
        }

        buttonStop.setOnClickListener {
            var myIntent=Intent(this,MyService::class.java)
            stopService(myIntent)
        }


        buttonSave.setOnClickListener {
//             var username =editTextUsername.text.toString()
//             var editor=sp.edit()
//             editor.putString("keyusername",username)
//             editor.commit()
//
//             editTextUsername.setText("")
            if(remCreds.isChecked){
                var username =editTextUsername.text.toString()
                var password=editTextTextPassword.text.toString()


                var editor=sp.edit()
                editor.putString("keyusername",username)
                editor.putString("keypassword",password)
                editor.commit()
                Toast.makeText(this,"Inside IF", Toast.LENGTH_SHORT).show()
                editTextUsername.setText("")
                editTextTextPassword.setText("")
                Toast.makeText(this,"At the end of IF", Toast.LENGTH_SHORT).show()

            }
            else{
                //do nothing
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id =item.itemId
        if(id==R.id.logout){
            logout()
            Toast.makeText(this,"LOGGING OUT",Toast.LENGTH_LONG).show()

            return true
        }
        if(id==R.id.settings){
            Toast.makeText(this,"Settings",Toast.LENGTH_LONG).show()
            return true

        }
        return super.onOptionsItemSelected(item)
    }

    public fun logout(){
        val intent = Intent(this,FlagActivity::class.java)
        startActivity(intent)
    }




}