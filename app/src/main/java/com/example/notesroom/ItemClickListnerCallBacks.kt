package com.example.notesroom

import com.example.notesroom.room.Note

interface ItemClickListnerCallBacks {
    fun deleteBtnClick(note:Note)
    fun itemClick(note: Note)

}