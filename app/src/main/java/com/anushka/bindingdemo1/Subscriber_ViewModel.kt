package com.mynotes.notes

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynotes.notes.db.Subcriber_Data
import com.mynotes.notes.db.Subscriver_Repositery
import kotlinx.coroutines.launch

class Subscriber_ViewModel(private val repositery: Subscriver_Repositery) :ViewModel(),Observable {
    val subscriver = repositery.subscrivr

    @Bindable
    val inutname = MutableLiveData<String>()
    @Bindable
    val emal = MutableLiveData<String>()
    @Bindable
    val saveorUpdatebutton =MutableLiveData<String>()
    @Bindable
    val deleteButton = MutableLiveData<String>()

    init {
        saveorUpdatebutton.value = "Save"
        deleteButton.value = "Delete"
    }
    fun saveUpdate(){
        val name = inutname.value!!
        val email = emal.value!!

        insert(Subcriber_Data(0,name,email))
        inutname.value =null
        emal.value =null

    }
    fun  clearall(){
        clerAll()


    }

    fun insert(subscriber: Subcriber_Data){
        viewModelScope.launch {
            repositery.insert(subscriber)
        }
    }
    fun update(subscriber: Subcriber_Data){
        viewModelScope.launch {
            repositery.update(subscriber)
        }
    }
    fun delete(subscriber: Subcriber_Data){
        viewModelScope.launch {
            repositery.delte(subscriber)
        }
    }
    fun clerAll(){
        viewModelScope.launch { repositery.delteAll() }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}