package com.urmilshroff.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashScreenActivity:AppCompatActivity()
{

    val delay:Long=3000 //shows splash screen for 3 seconds

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val myIntent=Intent(this,MainActivity::class.java)
            startActivity(myIntent)
            finish()

        },delay)

    }
}