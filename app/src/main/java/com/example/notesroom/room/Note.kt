package com.example.notesroom.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
data class Note(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val contentOfNote: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)
