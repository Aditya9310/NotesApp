package com.example.notesroom.callbacks

import com.example.notesroom.room.Note

class OnDeleteClick(val deleteListener: (note: Note) -> Unit)
