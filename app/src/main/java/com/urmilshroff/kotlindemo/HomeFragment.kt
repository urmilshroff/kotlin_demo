package com.urmilshroff.kotlindemo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*


private const val ARG_PARAM1="param1"
private const val ARG_PARAM2="param2"

class HomeFragment:Fragment()
{
    private var param1:String?=null
    private var param2:String?=null
    private var listener:OnFragmentInteractionListener?=null

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1=it.getString(ARG_PARAM1)
            param2=it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,
                              savedInstanceState:Bundle?):View? //try not to put any code here
    {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view:View,savedInstanceState:Bundle?) //everything here is executed once the actual fragment has been created, so put all logic/code here
    {
        super.onViewCreated(view,savedInstanceState)

        val username=SharedPrefObj.getUsername(this.activity!!)
        textViewHello.text="Welcome, $username!"
    }

    fun onButtonPressed(uri:Uri)
    {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context:Context)
    {
        super.onAttach(context)
        if(context is OnFragmentInteractionListener)
        {
            listener=context
        }
        else
        {
            throw RuntimeException(context.toString()+" must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach()
    {
        super.onDetach()
        listener=null
    }

    interface OnFragmentInteractionListener
    {
        fun onFragmentInteraction(uri:Uri)
    }

    companion object
    {
        @JvmStatic
        fun newInstance()=
                HomeFragment().apply {
                    arguments=Bundle().apply {
                        putString(ARG_PARAM1,param1)
                        putString(ARG_PARAM2,param2)
                    }
                }
    }
}