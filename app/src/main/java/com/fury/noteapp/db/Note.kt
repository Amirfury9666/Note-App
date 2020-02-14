package com.fury.noteapp.db

import android.view.View
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
class Note {
    var titile: String = ""
    var desc: String = ""
    var priority: String = ""

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

}