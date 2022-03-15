package com.example.notesroom.repo

import androidx.lifecycle.LiveData
import com.example.notesroom.room.Note
import com.example.notesroom.room.NoteDao

class NoteRepo(private val noteDao: NoteDao) {

    val getAllNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun saveNote(note: Note) {
        noteDao.saveNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    suspend fun getNoteId(noteId: Long): Note {
        return noteDao.getNoteId(noteId)
    }

}