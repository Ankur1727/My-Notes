package com.mynotes.notes

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModulClas() : ViewModel(), Observable {
    @Bindable
    var count = MutableLiveData<Int>()

    val totalcount: LiveData<Int>
        get() = count
    @Bindable
    val  inputtext  = MutableLiveData<String>()
//
    init {
        count.value =0
    }

    //    fun setCurrentNumber():Int{
//        return  count
//    }
    fun getUpdateCount() {
        val totalinut :Int = inputtext.value!!.toInt()
        count.value = (count.value)?.plus(totalinut)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}