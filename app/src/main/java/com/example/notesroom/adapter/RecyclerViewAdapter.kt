package com.example.notesroom.adapter.testpackage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroom.databinding.ItemViewBinding
import com.example.notesroom.room.Note
import com.example.notesroom.viewholder.RecyclerViewViewHolder

class RecyclerViewAdapter(
    private val listOfNote: List<Note>,
    private val onDeleteClick: (Note) -> Unit,
    private val itemClick: (Note) -> Unit
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
                    onDeleteClick(this)
                }
                binding.itemContainer.setOnClickListener {
                    itemClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfNote.size
    }
}