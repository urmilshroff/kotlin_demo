package com.urmilshroff.kotlindemo

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object SharedPrefObj
{
    lateinit var sharedPrefVar:SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    fun setUsername(context:Context,username:String?)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.putString("username",username) //key value pair
        editor.apply()
        editor.commit()
    }

    fun getUsername(context:Context):String?
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPrefVar.getString("username",null)
    }

    fun setEmail(context:Context,email:String?)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.putString("email",email)
        editor.apply()
        editor.commit()
    }

    fun getEmail(context:Context):String?
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPrefVar.getString("email",null)
    }

    fun destroyData(context:Context)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.remove("username")
        editor.clear()
        editor.commit()
    }

//    fun setImage(context:Context,image:String)
//    {
//        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
//        editor=sharedPrefVar.edit()
//        editor.putString("Image placeholder",value)
//        editor.commit()
//    }
//
//    fun getImage(context:Context):String?
//    {
//        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
//        return sharedPrefVar.getString()
//    }
}