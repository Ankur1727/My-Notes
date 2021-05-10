package com.mynotes.notes.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    @Insert
    suspend fun insersubscirber(subcriberData: Subcriber_Data)

    @Update
    suspend fun updatesubscriber(subcriberData: Subcriber_Data)

    @Delete
    suspend fun deletesubscriber(subcriberData: Subcriber_Data)

    @Query("DELETE FROM subcirber_data_name")
    suspend fun deleteAll()

    @Query("SELECT * FROM subcirber_data_name")
    fun getAllsubscriber():LiveData<List<Subcriber_Data>>
}