package com.vaibhav.activitylifecycle

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    var titlename:String?="UNKNOWN"
    lateinit var typemessage:EditText
    lateinit var sendbutton:Button
    lateinit var logoutbutton:Button
    lateinit var sharedPreferences: SharedPreferences
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        titlename=sharedPreferences.getString("Title","vaibhav_default_avenger_name")
//        if(intent!=null){
//            titlename=intent.getStringExtra("name")
//        }
        title=titlename

        typemessage=findViewById(R.id.typemessage)
        sendbutton=findViewById(R.id.sendbutton)
        logoutbutton=findViewById(R.id.logoutbutton)
        sendbutton.setOnClickListener{
            var type_message=typemessage.text.toString()
            val intent= Intent(this,MessageActivity::class.java)
            savedpreference(type_message)
            //////intent.putExtra("msg",type_message)
            startActivity(intent)
        }
        logoutbutton.setOnClickListener{
            val intent=Intent(this,NewActivity::class.java)
            sharedPreferences.edit().clear().apply()
            startActivity(intent)
        }
    }
    fun savedpreference(msg:String){
        sharedPreferences.edit().putString("message",msg).apply()
    }
}