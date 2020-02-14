package com.fury.noteapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fury.noteapp.repository.NoteRepository
import com.fury.noteapp.viewmodel.NoteViewModel

class ViewModelFactory(private val repository : NoteRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass){
            when{
                isAssignableFrom(NoteViewModel::class.java) -> NoteViewModel(repository)
                else -> error("Invalid View Model")
            }
        }as T
}