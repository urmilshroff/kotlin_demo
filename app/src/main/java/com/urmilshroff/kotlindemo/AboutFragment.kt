package com.urmilshroff.kotlindemo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_about.*


private const val ARG_PARAM1="param1"
private const val ARG_PARAM2="param2"

class AboutFragment:Fragment()
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
                              savedInstanceState:Bundle?):View?
    {
        return inflater.inflate(R.layout.fragment_about,container,false)
    }

    override fun onViewCreated(view:View,savedInstanceState:Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)

        floatingActionButtonOpenGitHub?.setOnClickListener{view->githubOpener()}
    }

    fun githubOpener() //opens Kotlin Demo GitHub repo
    {
        val repoLink:String?="https://github.com/urmilshroff/kotlin_demo"

        val githubIntent=Intent(Intent.ACTION_VIEW)
        githubIntent.data=Uri.parse(repoLink)

        Toast.makeText(this.activity!!,"Opening repository on GitHub...",Toast.LENGTH_SHORT).show()

        startActivity(githubIntent)
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
                AboutFragment().apply {
                    arguments=Bundle().apply {
                        putString(ARG_PARAM1,param1)
                        putString(ARG_PARAM2,param2)
                    }
                }
    }
}