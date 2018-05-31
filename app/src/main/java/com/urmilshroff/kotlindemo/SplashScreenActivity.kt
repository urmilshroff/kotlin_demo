package com.urmilshroff.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

class SplashScreenActivity:AppCompatActivity()
{

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Timer().schedule(
                object : TimerTask()
                {
                    override fun run()
                    {
                        val myIntent=Intent(this@SplashScreenActivity,MainActivity::class.java)
                        startActivity(myIntent)
                    }
                },
                3000L
        )

    }
}
