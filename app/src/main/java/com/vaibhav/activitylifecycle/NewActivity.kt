package com.vaibhav.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewActivity : AppCompatActivity(){

    lateinit var mobileno:EditText
    lateinit var password:EditText
    lateinit var forgotpassword:TextView
    lateinit var registeryourself:TextView
    lateinit var button: Button
    val valid_mobile:String="8505983922"
    val valid_password= arrayOf("vaibhav","tony","hulk","elvish")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val isloggedin=sharedPreferences.getBoolean("isloggedin",false)

        if(isloggedin){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
//            finish()
        }

        title="LOG IN AVENGER APP"
        mobileno=findViewById(R.id.mobileno)
        password=findViewById(R.id.password)
        forgotpassword=findViewById(R.id.forgotpassword)
        registeryourself=findViewById(R.id.registeryourself)
        button=findViewById(R.id.button)

        button.setOnClickListener{

            var mob:String=mobileno.text.toString()
            var pass:String=password.text.toString()
            val intent=Intent(this,MainActivity::class.java)
            val avenger_name:String

            if(mob==valid_mobile){
                if(pass==valid_password[0]){
//                    savedpreference()
                    avenger_name="vaibhav"
                    savedpreference(avenger_name)
//                    intent.putExtra("name",avenger_name)
                    startActivity(intent)
                }
                else if(pass==valid_password[1]){
                    avenger_name="tony"
                    savedpreference(avenger_name)
                    startActivity(intent)
                }
                else if(pass==valid_password[2]){
                    avenger_name="hulk"
                    savedpreference(avenger_name)
                    startActivity(intent)
                }
                else if(pass==valid_password[3]){
                    avenger_name="elvish"
                    savedpreference(avenger_name)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@NewActivity,"INVALID CREDENTIALS",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this@NewActivity, "INVALID CREDENTIALS", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
     fun savedpreference(avenger_name:String){
        sharedPreferences.edit().putBoolean("isloggedin",true).apply()
         sharedPreferences.edit().putString("Title",avenger_name).apply()
    }
}



