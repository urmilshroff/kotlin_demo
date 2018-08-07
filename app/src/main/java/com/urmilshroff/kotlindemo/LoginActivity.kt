package com.urmilshroff.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity:AppCompatActivity()
{
    lateinit var button:Button
    lateinit var usernameString:String
    lateinit var passwordString:String

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        if(SharedPrefObj.getUsername(this@LoginActivity)!=null)
        {
            Toast.makeText(this,"Account already exists",Toast.LENGTH_SHORT).show()
            val skipLogin=Intent(this,MainActivity::class.java)
            startActivity(skipLogin)
            finish()
        }

        else
        {
            buttonLogin.setOnClickListener({onClick()})
        }
    }

    private fun onClick()
    {
        usernameString=editTextUsername.text.toString()
        passwordString=editTextPassword.text.toString()

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