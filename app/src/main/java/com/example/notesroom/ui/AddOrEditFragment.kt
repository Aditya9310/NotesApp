package com.example.notesroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesroom.NoteApplication
import com.example.notesroom.databinding.FragmentAddOrEditBinding
import com.example.notesroom.room.Note
import com.example.notesroom.viewmodels.NoteViewModelFactory
import com.example.notesroom.viewmodels.NotesViewModel
import kotlinx.coroutines.launch


class AddOrEditFragment : Fragment() {
    private lateinit var binding: FragmentAddOrEditBinding
    private val args: AddOrEditFragmentArgs by navArgs()
    lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddOrEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            NoteViewModelFactory((context?.applicationContext as NoteApplication).repository)
        )[NotesViewModel::class.java]
        binding.saveBtn.setOnClickListener {
            saveNote()
        }
        if (args.noteId != -1L) {
            setOldNoteData(args.noteId)
        }
    }

    private fun saveNote() {
        val title = binding.title.text.toString()
        val contentOfNote = binding.contentOfNote.text.toString()
        if (title.isNotBlank() && contentOfNote.isNotBlank()) {
            val note = if (args.noteId == -1L) {
                Note(title, contentOfNote)
            } else {
                Note(title, contentOfNote, args.noteId)
            }
            viewModel.save(note)
            Toast.makeText(context, "Note Is Saved Successfully", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        } else {
            Toast.makeText(context, "All fields are mandatory", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setOldNoteData(noteId: Long) {
        lifecycleScope.launch {
            val note = viewModel.getNoteId(noteId)
            binding.title.setText(note.title)
            binding.contentOfNote.setText(note.contentOfNote)
        }
    }
}