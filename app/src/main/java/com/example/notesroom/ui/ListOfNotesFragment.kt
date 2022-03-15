package com.example.notesroom.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesroom.NoteApplication
import com.example.notesroom.adapter.testpackage.RecyclerViewAdapter
import com.example.notesroom.databinding.FragmentListOfNotesBinding
import com.example.notesroom.room.Note
import com.example.notesroom.viewmodels.NoteViewModelFactory
import com.example.notesroom.viewmodels.NotesViewModel


class ListOfNotesFragment : Fragment() {
    lateinit var binding: FragmentListOfNotesBinding
    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfNotesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            NoteViewModelFactory((context?.applicationContext as NoteApplication).repository)
        )[NotesViewModel::class.java]

        setUpRecyclerView()

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ListOfNotesFragmentDirections.actionListOfNotesFragmentToAddOrEditFragment())
        }

        backButtonHandle()
    }

    private fun backButtonHandle() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    activity?.let { finishAffinity(it) }
                }
            })
    }

    private fun setUpRecyclerView() {
        viewModel.allNotes.observe(viewLifecycleOwner) { it ->
            binding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            //   binding.recyclerView.adapter = RecyclerViewAdapter(it, this)
            binding.recyclerView.adapter =
                RecyclerViewAdapter(it, { note -> viewModel.delete(note) },
                     { note -> changeFrag(note) })
        }
    }

    fun changeFrag(note: Note) {
        findNavController().navigate(
            ListOfNotesFragmentDirections.actionListOfNotesFragmentToAddOrEditFragment(
                note.id
            )
        )
    }
}
