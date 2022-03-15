package com.example.notesroom.adapter.testpackage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroom.callbacks.OnDeleteClick
import com.example.notesroom.callbacks.OnItemClick
import com.example.notesroom.databinding.ItemViewBinding
import com.example.notesroom.room.Note
import com.example.notesroom.viewholder.RecyclerViewViewHolder

class RecyclerViewAdapter(
    private val listOfNote: List<Note>,
    private val onDeleteClick: OnDeleteClick,
    private val itemClick: OnItemClick
) : RecyclerView.Adapter<RecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        with(holder) {
            with(listOfNote[position]) {
                binding.titleTv.text = this.title
                binding.descriptionTv.text = this.contentOfNote
                binding.deleteBtn.setOnClickListener {
                    onDeleteClick.deleteListener(this)
                }
                binding.itemContainer.setOnClickListener {
                    itemClick.item(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfNote.size
    }
}