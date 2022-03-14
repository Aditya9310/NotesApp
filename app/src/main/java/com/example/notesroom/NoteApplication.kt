package com.example.notesroom

import android.app.Application
import com.example.notesroom.repo.NoteRepo
import com.example.notesroom.room.NoteDataBase

class NoteApplication : Application() {
    val dataBase by lazy { NoteDataBase.getDataBase(this) }
    val repository by lazy { NoteRepo(dataBase.getNoteDao()) }
}