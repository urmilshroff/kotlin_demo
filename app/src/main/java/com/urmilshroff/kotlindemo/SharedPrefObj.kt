package com.urmilshroff.kotlindemo

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object SharedPrefObj
{
    lateinit var sharedPrefVar:SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    fun setUsername(context:Context,user:String?)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.putString("userName",user) //variable name must be exactly the same
        editor.apply()
        editor.commit()
    }

    fun getUsername(context:Context):String?
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPrefVar.getString("userName",null) //key value pair
    }

    fun destroyData(context:Context)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.remove("userName")
        editor.clear()
        editor.commit()
    }

    fun setImage(context:Context,value:String)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.putString("Image placeholder",value)
        editor.commit()
    }

    fun getImage(context:Context):String?
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPrefVar.getString("") //fix
    }
}