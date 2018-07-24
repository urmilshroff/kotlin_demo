package com.urmilshroff.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity:AppCompatActivity()
{
    lateinit var usernameInput:EditText
    lateinit var passwordInput:EditText
    val button1=findViewById<Button>(R.id.button1)

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button1?.setOnClickListener{onClick()}
    }

    private fun onClick()
    {
        Toast.makeText(this,"Hi",Toast.LENGTH_SHORT).show()
    }
}