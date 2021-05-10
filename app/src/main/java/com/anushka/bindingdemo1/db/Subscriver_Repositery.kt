package com.mynotes.notes.db

class Subscriver_Repositery (private val dao: Dao) {

    val subscrivr  =dao.getAllsubscriber()

    suspend fun insert(subscriber:Subcriber_Data){
        dao.insersubscirber(subscriber)
    }
    suspend fun update(subscriber: Subcriber_Data){
        dao.updatesubscriber(subscriber)
    }
    suspend fun delte(subscriber: Subcriber_Data){
        dao.deletesubscriber(subscriber)
    }

    suspend fun delteAll(){
        dao.deleteAll()
    }
}