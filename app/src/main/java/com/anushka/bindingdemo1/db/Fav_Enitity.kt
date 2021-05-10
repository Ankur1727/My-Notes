package com.mynotes.notes.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity
data class Fav_Enitity
    (
var fav :String
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id :Int=0

}