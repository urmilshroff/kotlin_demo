package com.urmilshroff.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity:AppCompatActivity()
{
    val button:Button=findViewById(R.id.button1)
    lateinit var usernameInput:EditText=findViewById(R.id.editText1)
    lateinit var passwordInput:EditText=findViewById(R.id.editText2)

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener()
        {
            onClick()
        }
    }

    private fun onClick()
    {
        var usernameString:String=usernameInput.text.toString()
        var passwordString:String=passwordInput.text.toString()

        if(usernameString.isEmpty())
        {
            Toast.makeText(this,"Please enter a username",Toast.LENGTH_SHORT).show()
        }

        else if(passwordString.isEmpty())
        {
            Toast.makeText(this,"Please enter a username",Toast.LENGTH_SHORT).show()
        }

        else
        {
            Toast.makeText(this,"Login successful!",Toast.LENGTH_SHORT).show()
        }

    }
}