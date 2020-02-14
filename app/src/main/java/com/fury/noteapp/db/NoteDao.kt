package com.fury.noteapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note  : Note)

    @Delete
    fun deleteNote(note : Note)


    @Query("DELETE FROM note_table")
    fun deleteAllNotes()


    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    fun getAllNotes () : LiveData<MutableList<Note>>
}