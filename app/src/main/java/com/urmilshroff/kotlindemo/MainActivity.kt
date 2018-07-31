package com.urmilshroff.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView


class MainActivity:AppCompatActivity()
{
    var helloMessage:TextView

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloMessage=findViewById(R.id.textView1)
        helloMessage.setText("")
    }

}