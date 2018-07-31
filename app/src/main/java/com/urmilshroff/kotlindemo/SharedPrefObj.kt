package com.urmilshroff.kotlindemo

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object SharedPrefObj
{
    lateinit var sharedPrefVar:SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    fun getUsername(context:Context):String?
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPrefVar.getString("userName",null) //key value pair
    }

    fun setUsername(context:Context,user:String?)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.putString("userName",user) //variable name must be exactly the same
        editor.apply()
        editor.commit()
    }

    fun deleteData(context:Context)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.remove("userName")
        editor.clear()
        editor.commit()
    }
}