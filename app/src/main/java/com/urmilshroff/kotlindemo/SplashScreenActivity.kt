package com.urmilshroff.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashScreenActivity:AppCompatActivity()
{

    private val TIME: Long = 3000

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed({
            val myIntent = Intent(this,MainActivity::class.java)
            startActivity(myIntent)
            finish()

        },TIME)


        


//        Timer().schedule(
//                object : TimerTask()
//                {
//                    override fun run()
//                    {
//                        val myIntent=Intent(this@SplashScreenActivity,MainActivity::class.java)
//                        startActivity(myIntent)
//                        finish()
//                    }
//                },
//                3000L
//        )

    }
}
