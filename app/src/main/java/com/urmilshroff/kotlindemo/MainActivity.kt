package com.urmilshroff.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity



class MainActivity:AppCompatActivity()
{

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    override fun onBackPressed()
//    {
//
//        val builder=AlertDialog.Builder(this@MainActivity)
//
//        builder.setTitle(R.string.app_name)
//
//        builder.setMessage("Are you sure you want to quit?")
//                .setCancelable(true)
//                .setPositiveButton("Quit",DialogInterface.OnClickListener {dialog,id->
//                .setNegativeButton("Cancel",DialogInterface.OnClickListener {dialog,id-> dialog.cancel()})
//
//        val alert=builder.create()
//        alert.show()
//
//    }

}
