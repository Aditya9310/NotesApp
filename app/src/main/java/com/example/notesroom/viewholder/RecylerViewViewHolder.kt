package com.example.notesroom.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroom.R

class RecylerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.titleTv)
    val description = itemView.findViewById<TextView>(R.id.descriptionTv)
    val deleteBtn = itemView.findViewById<ImageView>(R.id.deleteBtn)
}