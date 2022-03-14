package com.example.notesroom.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesroom.repo.NoteRepo
import com.example.notesroom.room.Note
import kotlinx.coroutines.launch

class NotesViewModel(val repo: NoteRepo) : ViewModel() {

    val allNotes = repo.getAllNotes

    fun save(note: Note) {
        viewModelScope.launch {
            repo.saveNote(note)
        }

    }

    fun delete(note: Note) {
        viewModelScope.launch {
            repo.deleteNote(note)
        }
    }

    suspend fun getNoteId(noteId: Long): Note {
        return repo.getNoteId(noteId)
    }


}

