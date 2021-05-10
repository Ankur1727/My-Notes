package com.mynotes.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mynotes.notes.db.Subscriver_Repositery
import java.lang.IllegalArgumentException

class Subscriver_ViewModel_Factory (private val repositery:Subscriver_Repositery):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Subscriber_ViewModel::class.java)){
            return Subscriber_ViewModel(repositery) as T
        }
        throw IllegalArgumentException("Unkonw Erroo")

    }
}