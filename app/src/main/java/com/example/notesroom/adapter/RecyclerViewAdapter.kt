package com.example.notesroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroom.ItemClickListnerCallBacks
import com.example.notesroom.R
import com.example.notesroom.room.Note
import com.example.notesroom.viewholder.RecylerViewViewHolder

class RecyclerViewAdapter(private val listOfNote: List<Note>,private val ClickListner: ItemClickListnerCallBacks) : RecyclerView.Adapter<RecylerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylerViewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return RecylerViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecylerViewViewHolder, position: Int) {
        val note = listOfNote[position]
        holder.title.text = note.title
        holder.description.text = note.contentOfNote
        holder.deleteBtn.setOnClickListener {
            ClickListner.deleteBtnClick(note)
        }
        holder.itemView.setOnClickListener {
            ClickListner.itemClick(note)
        }
    }

    override fun getItemCount(): Int {
        return listOfNote.size
    }
}