package com.urmilshroff.kotlindemo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

private const val ARG_PARAM1="param1"
private const val ARG_PARAM2="param2"

class RecyclerViewFragment:Fragment()
{
    private var param1:String?=null
    private var param2:String?=null
    private var listener:OnFragmentInteractionListener?=null

    private var myList=ArrayList<ListClass>()
    private var myAdapter:MoviesRecyclerAdapter?=null
    private var recyclerView:RecyclerView?=null

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
        return inflater.inflate(R.layout.fragment_recycler_view,container,false)
    }

    fun onViewCreated()
    {

        myAdapter = MoviesRecyclerAdapter(myList)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = myAdapter

        prepareMoviesData()
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
                RecyclerViewFragment().apply {
                    arguments=Bundle().apply {
                        putString(ARG_PARAM1,param1)
                        putString(ARG_PARAM2,param2)
                    }
                }
    }

    private fun prepareMoviesData() {
        var movie = ListClass("Mad Max: Fury Road", "Action & Adventure", "2015",R.mipmap.ic_launcher)
        myList.add(movie)

        movie = ListClass("Inside Out", "Animation, Kids & Family", "2015",R.mipmap.ic_launcher)
        myList.add(movie)

        movie = ListClass("Star Wars: Episode VII - The Force Awakens", "Action", "2015",R.mipmap.ic_launcher)
        myList.add(movie)

        movie = ListClass("Shaun the Sheep", "Animation", "2015",R.mipmap.ic_launcher)
        myList.add(movie)

        myAdapter!!.notifyDataSetChanged()
    }
}

class MoviesRecyclerAdapter(private val moviesList: List<ListClass>) : RecyclerView.Adapter<MoviesRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title:TextView= view.findViewById<TextView>(R.id.title)
        var year:TextView= view.findViewById<TextView>(R.id.year)
        var genre:TextView= view.findViewById<TextView>(R.id.genre)
        var image:ImageView= view.findViewById<ImageView> (R.id.thumbnail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val Movies = moviesList[position]
        holder.title.text = Movies.title
        holder.genre.text = Movies.genre
        holder.year.text = Movies.year
        holder.image.setImageResource(Movies.image)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}