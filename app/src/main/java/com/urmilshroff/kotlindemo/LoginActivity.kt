package com.urmilshroff.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity:AppCompatActivity()
{
    lateinit var button:Button
    lateinit var usernameString:String
    lateinit var emailString:String

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState) //never put anything before this line!
        setContentView(R.layout.activity_login)

        if(SharedPrefObj.getUsername(this@LoginActivity)!=null)
        {
            val username=SharedPrefObj.getUsername(this@LoginActivity)
            Toast.makeText(this,"Welcome back, $username",Toast.LENGTH_SHORT).show()

            val skipLogin=Intent(this,NavDrawerActivity::class.java)
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
        emailString=editTextEmail.text.toString()

        if(usernameString.isEmpty())
        {
            Toast.makeText(this,"Please enter a username",Toast.LENGTH_SHORT).show()
        }

        else if(emailString.isEmpty())
        {
            Toast.makeText(this,"Please enter an email address",Toast.LENGTH_SHORT).show()
        }

        else
        {
            SharedPrefObj.setUsername(this@LoginActivity,usernameString) //obj.fun(params)
            SharedPrefObj.setEmail(this@LoginActivity,emailString)

            Toast.makeText(this,"Login successful!",Toast.LENGTH_SHORT).show()

            val myIntent=Intent(this,NavDrawerActivity::class.java)
            startActivity(myIntent)
            finish()
        }
    }
}