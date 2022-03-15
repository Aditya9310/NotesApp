package com.example.notesroom.adapter.testpackage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroom.callbacks.OnClick
import com.example.notesroom.databinding.ItemViewBinding
import com.example.notesroom.room.Note
import com.example.notesroom.viewholder.RecylerViewViewHolder

class RecyclerViewAdapter(
    private val listOfNote: List<Note>,
    private val onClickListener: OnClick,
) : RecyclerView.Adapter<RecylerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylerViewViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecylerViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecylerViewViewHolder, position: Int) {
        with(holder) {
            with(listOfNote[position]) {
                binding.titleTv.text = this.title
                binding.descriptionTv.text = this.contentOfNote
                binding.deleteBtn.setOnClickListener {
                    onClickListener.deleteListener(this)
                }
                binding.itemContainer.setOnClickListener {
                    onClickListener.itemClick(this)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return listOfNote.size
    }
}