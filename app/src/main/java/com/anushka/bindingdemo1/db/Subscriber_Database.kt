package com.mynotes.notes.db

import android.content.Context
import android.provider.CalendarContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Subcriber_Data::class],version = 1)
abstract class Subscriber_Database :RoomDatabase (){
    abstract val dao :Dao

    companion object{
        private var INSTACE: Subscriber_Database?=null
        fun getInstance(context: Context):Subscriber_Database{
            synchronized(this){
                var instance = INSTACE
                if (instance==null){
                    instance = databaseBuilder(
                        context.applicationContext,
                        Subscriber_Database::class.java,
                        "subscrber_database"
                    ).build()
                }
                return instance

            }
        }
    }
}