package com.mynotes.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.mynotes.notes.databinding.ActivityCoroutineDemoBinding
import kotlinx.coroutines.*

class Coroutine_Demo : AppCompatActivity() {
    private lateinit var databing :ActivityCoroutineDemoBinding
    var count:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_coroutine__demo)
        databing = DataBindingUtil.setContentView(this,R.layout.activity_coroutine__demo)
//        CoroutineScope(Dispatchers.Main).launch {
//            main_downloadData()
//        }
        databing.secondButton.setOnClickListener {
            databing.txtSeond.text = count++.toString()
        }
        databing.firstButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadData()

            }
        }

    }
    private suspend fun downloadData(){
        for(i in 1..200000){
           // Log.i("my tag","Downloafing user $i in ${Thread.currentThread().name}")
            withContext(Dispatchers.Main){
                databing.txtFirst.text = "Downloafing user $i in ${Thread.currentThread().name}"

            }
    }
//    private fun main_downloadData(){
//        for(i in 1..200000){
//            Log.i("my main","Downloafing main $i in ${Thread.currentThread().name}")
//
//        }

    }
}
