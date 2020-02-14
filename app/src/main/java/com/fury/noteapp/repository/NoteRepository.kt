package com.fury.noteapp.repository

import androidx.lifecycle.LiveData
import com.fury.noteapp.db.Note
import com.fury.noteapp.db.NoteDateBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository(private val db: NoteDateBase){

    fun insertNote(note : Note){
        CoroutineScope(Dispatchers.IO).launch {
            db.getDao().insert(note)
        }
    }

    fun deleteNote(note : Note){
        CoroutineScope(Dispatchers.IO).launch {
            db.getDao().deleteNote(note)
        }
    }

    fun deleteAllNotes(){
        CoroutineScope(Dispatchers.IO).launch {
            db.getDao().deleteAllNotes()
        }
    }

    fun getAllNotes() : LiveData<MutableList<Note>> = db.getDao().getAllNotes()
}