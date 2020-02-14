package com.fury.noteapp.base

import android.app.Application
import com.fury.noteapp.db.NoteDao
import com.fury.noteapp.db.NoteDateBase
import com.fury.noteapp.repository.NoteRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class NoteApp : Application(),KodeinAware{

    override val kodein  = Kodein.lazy {
        import(androidXModule(this@NoteApp))
        bind() from singleton { NoteDateBase(instance()) }
        bind() from singleton { NoteRepository(instance()) }
        bind() from provider { ViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
    }
}