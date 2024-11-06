package com.example.triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class DisplayScoreFragment : Fragment() {

    private lateinit var congratsMessage: TextView
    private lateinit var scoreText: TextView
    private lateinit var restartButton: Button

    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            score = it.getInt("score", 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.score_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        congratsMessage = view.findViewById(R.id.congrats_message)
        scoreText = view.findViewById(R.id.score_text)
        restartButton = view.findViewById(R.id.restart_button)

        // Display the score
        val score = arguments?.getInt("score") ?: 0
        scoreText.text = "Your Score: $score/10"

        // Set click listener for the restart button
        restartButton.setOnClickListener {
            // Navigate back to the first question fragment
            findNavController().navigate(R.id.SelectionPage)
        }
    }
}
