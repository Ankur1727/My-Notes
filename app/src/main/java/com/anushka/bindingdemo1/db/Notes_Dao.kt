package com.mynotes.notes.db

import androidx.room.*
import androidx.room.Dao

@Dao
interface Notes_Dao {
    @Insert
    suspend fun addNote(notesDao: Notes_Enitiy)

    @Query("Select * from notes_enitiy ORDER BY id DESC")
   suspend fun getAllnote():List<Notes_Enitiy>

    @Query("Select * from notes_enitiy WHERE fav = 'true' ")
    suspend fun getAllFav():List<Notes_Enitiy>

    @Insert
   suspend fun addMultiples(vararg notesDao: Notes_Enitiy)
    @Update
    suspend fun upDate(notesDao: Notes_Enitiy)

    @Delete
    suspend fun deleteData(notesDao: Notes_Enitiy)
}