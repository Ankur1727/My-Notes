package com.mynotes.notes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database
    (entities = [Notes_Enitiy::class,Password_Entity::class],version = 3)
abstract class Notes_Database:RoomDatabase(){
    abstract fun getNotesDao():Notes_Dao
    abstract fun getPassword():Password_Dao

    companion object{
       @Volatile private var instance:Notes_Database?=null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?: buildDAtabase(context).also {
                instance = it
            }
        }
        private fun buildDAtabase(context: Context) = Room.databaseBuilder(
            context,Notes_Database::class.java,"notedatabase"

        ).build()
    }

}