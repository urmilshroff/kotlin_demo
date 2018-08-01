package com.urmilshroff.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity:AppCompatActivity()
{
    lateinit var button:Button
    lateinit var usernameInput:EditText
    lateinit var passwordInput:EditText
    lateinit var usernameString:String
    lateinit var passwordString:String

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button=findViewById(R.id.button1)
        usernameInput=findViewById(R.id.editText1)
        passwordInput=findViewById(R.id.editText2)

        if(SharedPrefObj.getUsername(this@LoginActivity)!=null)
        {
            val skipLogin=Intent(this,MainActivity::class.java)
            startActivity(skipLogin)
            finish()
        }

        else
        {
            button.setOnClickListener()
            {
                onClick()
            }
        }
    }

    private fun onClick()
    {
        usernameString=usernameInput.text.toString()
        passwordString=passwordInput.text.toString()

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
            SharedPrefObj.setUsername(this@LoginActivity,usernameString) //obj.function()!
            Toast.makeText(this,"Login successful!",Toast.LENGTH_SHORT).show()
            val myIntent=Intent(this,MainActivity::class.java)
            startActivity(myIntent)
            finish()
        }

    }
}