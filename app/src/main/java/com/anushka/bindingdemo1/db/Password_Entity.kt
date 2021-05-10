package com.mynotes.notes.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Password_Entity (
    @PrimaryKey
    var pas :String
)