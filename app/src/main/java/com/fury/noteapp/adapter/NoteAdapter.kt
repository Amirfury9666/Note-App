package com.fury.noteapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fury.noteapp.R
import com.fury.noteapp.base.BaseListAdapter
import com.fury.noteapp.db.Note

class NoteAdapter : BaseListAdapter<Note>(DiffCallBack(),null){

    override fun getItemViewType(position: Int): Int {
        return R.layout.note_item
    }
    class DiffCallBack : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.titile == newItem.titile && oldItem.desc == newItem.desc
        }
    }

    fun getNote(position  : Int) : Note{
        return getItem(position)
    }
}