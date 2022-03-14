package com.example.notesroom.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notesTable")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notesTable where id =:noteId")
    suspend fun getNoteId(noteId:Long):Note


}