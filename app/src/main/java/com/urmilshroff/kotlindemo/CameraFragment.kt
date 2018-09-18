package com.urmilshroff.kotlindemo

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.checkSelfPermission
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_camera.*
import java.io.ByteArrayOutputStream

private const val ARG_PARAM1="param1"
private const val ARG_PARAM2="param2"
private val MY_PERMISSIONS_REQUEST_CAMERA:Int=100
private val SELECT_PHOTO:Int=1
private val CAMERA:Int=1
internal var fileName:String?=null
private var selectedFilePath:String?=null
internal var sizevalue:Long=0

class CameraFragment:Fragment()
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
        return inflater.inflate(R.layout.fragment_camera,container,false)
    }

    override fun onViewCreated(view:View,savedInstanceState:Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        floatingActionButtonLaunchCamera?.setOnClickListener{view->onClick()}
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
                CameraFragment().apply {
                    arguments=Bundle().apply {
                        putString(ARG_PARAM1,param1)
                        putString(ARG_PARAM2,param2)
                    }
                }
    }

    fun onClick()
    {
        if (checkSelfPermission(this.activity!!,android.Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity!!, android.Manifest.permission.CAMERA)) // if permission is not granted
            {
                Snackbar.make(this!!.view!!,"Please grant permissions",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show()
            }

            else
            {
                Snackbar.make(this!!.view!!,"Else part",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show()

                ActivityCompat.requestPermissions(this.activity!!, arrayOf(android.Manifest.permission.CAMERA), MY_PERMISSIONS_REQUEST_CAMERA)
            }
        }

        else
        {
            clickPhoto()
        }
    }

    fun clickPhoto()
    {
            val myIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(myIntent,CAMERA)
    }

    override fun onActivityResult(requestCode:Int,resultCode:Int,data:Intent?)
    {
        super.onActivityResult(requestCode,resultCode,data)

        val photo=data!!.getExtras().get("data") as Bitmap
        val imageString:String=encodeToBase64(photo)
        SharedPrefObj.setImage(this.activity!!,imageString)
        imageViewSelectedImage.setImageBitmap(photo)
    }

    fun encodeToBase64(image:Bitmap):String
    {
        val baos=ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.PNG,100,baos)
        val b=baos.toByteArray()
        val imageEncoded=Base64.encodeToString(b,Base64.DEFAULT)
        return imageEncoded
    }
}