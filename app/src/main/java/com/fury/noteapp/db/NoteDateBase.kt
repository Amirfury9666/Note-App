package com.fury.noteapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class),version = 1)
abstract class NoteDateBase : RoomDatabase(){

    abstract fun getDao()  : NoteDao


    companion object{

        private var instance : NoteDateBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance?: buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context): NoteDateBase {

            return Room.databaseBuilder(context.applicationContext,NoteDateBase::class.java,"note.db").build()
        }
    }

}