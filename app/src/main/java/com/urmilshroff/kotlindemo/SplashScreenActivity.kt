package com.urmilshroff.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class SplashScreenActivity:AppCompatActivity()
{

    val delay:Long=2500 //shows splash screen for 2.5 seconds

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({

            if(SharedPrefObj.getUsername(this@SplashScreenActivity)!=null)
            {
                val username=SharedPrefObj.getUsername(this@SplashScreenActivity) //if user is already logged in
                Toast.makeText(this,"Welcome back, $username",Toast.LENGTH_SHORT).show()

                val skipLogin=Intent(this,NavDrawerActivity::class.java)
                startActivity(skipLogin)
                finish()
            }

            else
            {
                Toast.makeText(this,"Please login.",Toast.LENGTH_SHORT).show()

                val displayLogin=Intent(this,LoginActivity::class.java)
                startActivity(displayLogin)
                finish()
            }

        },delay)
    }
}