package com.fury.noteapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.fury.noteapp.R
import com.fury.noteapp.base.BaseActivity
import com.fury.noteapp.base.ViewModelFactory
import com.fury.noteapp.databinding.ActivityAddNoteBinding
import com.fury.noteapp.db.Note
import com.fury.noteapp.utility.toast
import com.fury.noteapp.viewmodel.NoteViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class AddNoteActivity : BaseActivity<ActivityAddNoteBinding>(),KodeinAware {

    override val kodein: Kodein by kodein()

    private lateinit var mNoteViewModel : NoteViewModel
    private val _viewModelFactory : ViewModelFactory by instance()

    private lateinit var mBinding : ActivityAddNoteBinding
    override val layoutRes: Int get() = R.layout.activity_add_note

    override fun getToolbar(binding: ActivityAddNoteBinding): Toolbar? = binding.toolbar

    override fun onActivityReady(instanceState: Bundle?, binding: ActivityAddNoteBinding) {
        mNoteViewModel = ViewModelProviders.of(this,_viewModelFactory).get(NoteViewModel::class.java)
        enableBack()
        setToolbarTitle("Add New Note")
        mBinding = binding
    }


    fun onSaveNoteClick(view : View){
        val title =mBinding.titleEt.text.toString().trim()
        var desc = mBinding.titleEt.text.toString().trim()

        when {
            title.isNullOrEmpty() -> {
                toast("Please Enter A Note Title")
            }
            desc.isNullOrEmpty() -> {
                toast("Please Enter Note Description")
            }
            else -> {
                val note = Note()
                note.titile  = title
                note.desc = desc
                mNoteViewModel.insertNote(note)
                finish()
                toast("Note Saved")
            }
        }
    }

}
