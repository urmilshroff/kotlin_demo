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
        return sharedPrefVar.getString("user_name",null) //key value pair
    }

    fun setUsername(context:Context,user:String?)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.putString("userName",user) //key value pair
        editor.apply()
        editor.commit()
    }

    fun deleteData(context:Context)
    {
        sharedPrefVar=PreferenceManager.getDefaultSharedPreferences(context)
        editor=sharedPrefVar.edit()
        editor.remove("user_name")
        editor.clear()
        editor.commit()
    }
}