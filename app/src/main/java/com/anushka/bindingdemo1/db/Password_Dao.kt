package com.mynotes.notes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface Password_Dao {

    @Insert
    suspend fun insertPassword(passwordEntity: Password_Entity)

    @Update
    suspend fun updatePassword(passwordEntity: Password_Entity)

    @Query("Select * from Password_Entity")
    suspend fun getPassowrd():List<Password_Entity>

}