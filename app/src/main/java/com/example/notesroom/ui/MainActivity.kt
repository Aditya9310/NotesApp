package com.example.notesroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.notesroom.NoteApplication
import com.example.notesroom.databinding.ActivityMainBinding
import com.example.notesroom.viewmodels.NoteViewModelFactory
import com.example.notesroom.viewmodels.NotesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}