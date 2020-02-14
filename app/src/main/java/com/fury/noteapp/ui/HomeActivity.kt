package com.fury.noteapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fury.noteapp.R
import com.fury.noteapp.adapter.NoteAdapter
import com.fury.noteapp.base.BaseActivity
import com.fury.noteapp.base.ViewModelFactory
import com.fury.noteapp.databinding.ActivityHomeBinding
import com.fury.noteapp.viewmodel.NoteViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : BaseActivity<ActivityHomeBinding>(),KodeinAware {
    override val kodein: Kodein by kodein()
    private val _viewModelFactory : ViewModelFactory by instance()
    private lateinit var mNoteViewModel: NoteViewModel
    private val mNoteAdapter = NoteAdapter()

    override val layoutRes: Int get() = R.layout.activity_home

    override fun getToolbar(binding: ActivityHomeBinding): Toolbar? {return binding.toolbar}

    override fun onActivityReady(instanceState: Bundle?, binding: ActivityHomeBinding) {
        mNoteViewModel = ViewModelProviders.of(this,_viewModelFactory).get(NoteViewModel::class.java)
        binding.noteRecycler.adapter = mNoteAdapter

        mNoteViewModel.getAllNotes().observe(this, Observer {
            mNoteAdapter.submitList(it)
        })
    }


    fun onAddNoteClick(view : View){
        startActivity(Intent(this,AddNoteActivity::class.java))
    }
}
