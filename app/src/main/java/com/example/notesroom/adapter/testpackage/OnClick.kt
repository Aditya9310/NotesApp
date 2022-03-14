package com.example.notesroom.adapter.testpackage

import com.example.notesroom.room.Note

class OnClick(val deleteListener: (note: Note) -> Unit)

{
    fun onDelete(note: Note) = deleteListener(note)
}