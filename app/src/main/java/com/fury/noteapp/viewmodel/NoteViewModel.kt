package com.fury.noteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fury.noteapp.repository.NoteRepository
import com.fury.noteapp.db.Note

class NoteViewModel (private val repository: NoteRepository): ViewModel(){


    fun insertNote(note: Note){
        repository.insertNote(note)
    }

    fun deleteNote(note: Note){
        repository.deleteNote(note)
    }

    fun deleteAllNotes(){
        repository.deleteAllNotes()
    }


    fun getAllNotes() : LiveData<MutableList<Note>> = repository.getAllNotes()
}