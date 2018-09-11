package com.urmilshroff.kotlindemo

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nav_drawer.*
import kotlinx.android.synthetic.main.app_bar_nav_drawer.*

class NavDrawerActivity:AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener,HomeFragment.OnFragmentInteractionListener, CameraFragment.OnFragmentInteractionListener,AboutFragment.OnFragmentInteractionListener
{
    override fun onFragmentInteraction(uri:Uri)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)
        setSupportActionBar(toolbar)

//        fab.setOnClickListener {view->
//            Snackbar.make(view,"Replace with your own action",Snackbar.LENGTH_LONG)
//                    .setAction("Action",null).show()
//        }

        val toggle=ActionBarDrawerToggle(
                this,drawer_layout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val username:String?=SharedPrefObj.getUsername(this@NavDrawerActivity)
        val email:String?=SharedPrefObj.getEmail(this@NavDrawerActivity)

//        Toast.makeText(this,"$username $email",Toast.LENGTH_SHORT).show()

//        textViewUsername.setText("Hello World") //setText not wworking
//        textViewEmail.setText("demo@kotlin.com")
    }

    override fun onBackPressed()
    {
        if(drawer_layout.isDrawerOpen(GravityCompat.START))
        {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
        else
        {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu:Menu):Boolean
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_drawer,menu)
        return true
    }

    override fun onOptionsItemSelected(item:MenuItem):Boolean
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when(item.itemId)
        {
            R.id.action_settings->return true
            else->return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item:MenuItem):Boolean
    {
        // Handle navigation view item clicks here.

        when(item.itemId)
        {
            R.id.nav_home->
            {
                Toast.makeText(this,"Home fragment",Toast.LENGTH_SHORT).show()

                val homeFragment=HomeFragment.newInstance()
                val transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_container,homeFragment).commit()
            }

            R.id.nav_camera->
            {
                Toast.makeText(this,"Camera fragment",Toast.LENGTH_SHORT).show()

                val cameraFragment=CameraFragment.newInstance()
                val transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_container,cameraFragment).commit()
            }

            R.id.nav_about->
            {
                Toast.makeText(this,"About fragment",Toast.LENGTH_SHORT).show()

                val aboutFragment=AboutFragment.newInstance()
                val transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_container,aboutFragment).commit()
            }

            R.id.nav_share->
            {
                Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show()
            }

            R.id.nav_send->
            {
                Toast.makeText(this,"Send",Toast.LENGTH_SHORT).show()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}