package com.mynotes.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.contentcapture.DataRemovalRequest
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mynotes.notes.adpter.Recycelerview_room_Adpter
import com.mynotes.notes.databinding.ActivityRoomdataDemoBinding
import com.mynotes.notes.db.Subscriber_Database
import com.mynotes.notes.db.Subscriver_Repositery

class Roomdata_Demo : AppCompatActivity() {
    private lateinit var databing :ActivityRoomdataDemoBinding
    private lateinit var viewModel: Subscriber_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    setContentView(R.layout.activity_roomdata__demo)
        databing = DataBindingUtil.setContentView(this,R.layout.activity_roomdata__demo)
        val dao = Subscriber_Database.getInstance(application).dao
        val respository = Subscriver_Repositery(dao)
        val factory = Subscriver_ViewModel_Factory(respository)
        viewModel = ViewModelProvider(this,factory).get(Subscriber_ViewModel::class.java)
        databing.myviewmodel = viewModel
        databing.lifecycleOwner= this
       init_recyclerview()


    }
    private  fun init_recyclerview(){
        databing.roomRecyecerview.layoutManager = LinearLayoutManager(this)
        displaySubscirber()
    }
    private fun displaySubscirber(){
        viewModel.subscriver.observe(this, Observer {
            Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
            Log.i("MyDatabase",it.toString())
            databing.roomRecyecerview.adapter = Recycelerview_room_Adpter(it)
        })
    }
}
