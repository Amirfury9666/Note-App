package com.fury.noteapp.callBack

interface IClickListener<T> {
    fun onItemClick(id : Int, item : T)
}