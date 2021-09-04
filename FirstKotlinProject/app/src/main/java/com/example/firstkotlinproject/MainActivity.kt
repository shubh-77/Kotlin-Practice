package com.example.firstkotlinproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(){
    // added for radio button value
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton;

    //added for check box
    lateinit var car: CheckBox
    lateinit var bike:CheckBox


    //added for spinner
//    lateinit var spinner: Spinner

    val dropDownList= arrayOf("option A","option B","option C")
    lateinit var choice: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("mytag","activity created")

        //for check box
        car = findViewById(R.id.checkBox1)
        bike=findViewById(R.id.checkBox2)

        var username:String;
        var pass:String;
        var gender:String;
        var intent:Intent;
        var vehicle:String;

        // added for radio button value
        radioGroup = findViewById(R.id.radioGroup)




//        added for spinner

//        spinner = findViewById(R.id.spinner)


        //to store checkbox vals
        val result = StringBuilder()
        //result.append("Selected Items")


        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,dropDownList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        statusFilter.adapter=adapter
        statusFilter.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (statusFilter.selectedItemPosition==0){
                    condition1()

                }
                if (statusFilter.selectedItemPosition==1){
                    condition2()
                }
                if (statusFilter.selectedItemPosition==2){
                    condition3()
                }


            }



        }














    button.setOnClickListener{
        if(editTextTextEmailAddress.text.isNullOrBlank()&&editTextTextPassword.text.isNullOrBlank()){
            Toast.makeText(this, "Please fill the required fields", Toast.LENGTH_SHORT).show()
        }

        else{
            username=editTextTextEmailAddress.text.toString();
            pass=editTextTextPassword.text.toString();
            // added for radio button value
            val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(intSelectButton)
            gender=radioButton.text.toString();


            /*Adding code for spinner */
//            val adapter = ArrayAdapter.createFromResource(
//                this,
//                R.array.birds,
//                android.R.layout.simple_spinner_item
//            )
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//            spinner.onItemSelectedListener = this









            if(username=="abc" && pass=="12345"){

                Toast.makeText(this, "${editTextTextEmailAddress.text}  is logged in!!", Toast.LENGTH_SHORT).show()
                // added for radio button value
                Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()
                //result.append("Total Vehicles")
                if(car.isChecked){
                    result.append("\nYou have car ")
                }
                if(bike.isChecked){
                    result.append("\nYou have bike ")
                }
                Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
                vehicle=result.toString()






                //Explicit Intent

                intent= Intent(this,SecondActivity::class.java)
                intent.putExtra("username",username)
                intent.putExtra("pass",pass)
                intent.putExtra("gender",gender)
                intent.putExtra("vehicle",vehicle)
                intent.putExtra("choice",choice)

                startActivity(intent)
            }
           else{
                Toast.makeText(this, "${editTextTextEmailAddress.text} username not found!!", Toast.LENGTH_SHORT).show()
            }
        }
        //Explicit Intent
        /*intent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:9769192527"))
        startActivity(intent)*/


    }

    }

    override fun onStart() {
        super.onStart()
        Log.i("mytag","activity Started")

    }

    override fun onPause() {
        super.onPause()
        Log.i("mytag","activity paused")

    }

    override fun onResume() {
        super.onResume()
        Log.i("mytag","activity resumed")

    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","activity stop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag","activity destroyed")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i("mytag","activity restart")

    }

//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        val text: String = parent?.getItemAtPosition(position).toString()
//        Toast.makeText(this,"$text",Toast.LENGTH_LONG).show()
//        //textView.text = text
//    }
//
//    override fun onNothingSelected(p0: AdapterView<*>?) {
//        TODO("Not yet implemented")
//    }



    private fun condition1(){
        Toast.makeText(this,"Selected item: "+statusFilter.selectedItem,Toast.LENGTH_LONG).show()
        choice=statusFilter.selectedItem.toString()

    }
    private fun condition2(){
        Toast.makeText(this,"Selected item: "+statusFilter.selectedItem,Toast.LENGTH_LONG).show()
        choice=statusFilter.selectedItem.toString()

    }
    private fun condition3(){
        Toast.makeText(this,"Selected item: "+statusFilter.selectedItem,Toast.LENGTH_LONG).show()
        choice=statusFilter.selectedItem.toString()

    }
}
