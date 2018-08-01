package com.urmilshroff.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView


class MainActivity:AppCompatActivity()
{
    lateinit var helloMessage:TextView

    override fun onCreate(savedInstanceState:Bundle?)
    {
        val userName=SharedPrefObj.getUsername(this@MainActivity)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloMessage=findViewById(R.id.textViewDesc)
        helloMessage.setText("Hi there, $userName!")
    }

}