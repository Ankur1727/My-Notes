package com.mynotes.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModulFactory(private val stringin :Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(ViewModulClas::class.java)){
//            return ViewModulClas(stringin)as T
//        }
        throw IllegalArgumentException("Unkown View Model Class")
    }
}