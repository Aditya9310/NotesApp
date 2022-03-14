package com.example.notesroom.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notesroom.databinding.FragmentSplashCustomBinding


class SplashFragmentCustom : Fragment() {

    private lateinit var binding: FragmentSplashCustomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSplashCustomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val settings: SharedPreferences = requireContext().getSharedPreferences("prefs", 0)
        val firstRun = settings.getBoolean("firstRun", false)
        if (firstRun == false) //if running for first time
        //Splash will load for first time
        {
            val editor = settings.edit()
            editor.putBoolean("firstRun", true)
            editor.apply()
            splashScreenTimer()

        }
        else{
            findNavController().navigate(SplashFragmentCustomDirections.actionSplashFragmentCustomToListOfNotesFragment())
        }

    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    fun splashScreenTimer(){
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(SplashFragmentCustomDirections.actionSplashFragmentCustomToListOfNotesFragment())
        }, 3000)

    }
}