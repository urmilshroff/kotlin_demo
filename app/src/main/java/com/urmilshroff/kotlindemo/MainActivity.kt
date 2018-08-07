package com.urmilshroff.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity:AppCompatActivity()
{
    override fun onCreate(savedInstanceState:Bundle?)
    {
        val userName=SharedPrefObj.getUsername(this@MainActivity)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewHello.setText("Hi there, $userName!")
    }
}