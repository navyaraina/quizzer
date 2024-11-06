package com.example.triviaapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import org.json.JSONObject

class MathsFragment : Fragment() {

    private lateinit var questionText: TextView
    private lateinit var option1: RadioButton
    private lateinit var option2: RadioButton
    private lateinit var option3: RadioButton
    private lateinit var option4: RadioButton

    // Load JSON from raw resources
    private val jsonString by lazy { loadJSONFromRaw() }
    private val jsonObject by lazy { JSONObject(jsonString) }
    private val questionsArray by lazy { jsonObject.getJSONArray("mathQuestions") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.questions_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionText = view.findViewById(R.id.question_text)
        option1 = view.findViewById(R.id.option1)
        option2 = view.findViewById(R.id.option2)
        option3 = view.findViewById(R.id.option3)
        option4 = view.findViewById(R.id.option4)

        var questionIndexCurrent = 0
        var score = 0

        getQuestions(questionIndexCurrent)
        val onOptionSelected = View.OnClickListener { view->
            val question = questionsArray.getJSONObject(questionIndexCurrent)
            val correctAnswerIndex = question.getInt("correctAnswerIndex")
            val selectedAnswerIndex = when (view.id) {
                R.id.option1 -> 0
                R.id.option2 -> 1
                R.id.option3 -> 2
                R.id.option4 -> 3
                else -> -1
            }

            if (selectedAnswerIndex == correctAnswerIndex) {
                score++ // Increment score if the selected answer is correct
            }

            Handler(Looper.getMainLooper()).postDelayed({
                questionIndexCurrent++
                if (questionIndexCurrent < questionsArray.length()) {
                    getQuestions(questionIndexCurrent)
                } else {
                    val bundle = Bundle().apply {
                        putInt("score", score)
                    }
                    findNavController().navigate(R.id.DisplayScoreFragment, bundle)
                }
            }, 3000) // 2000 milliseconds = 2-second delay
        }
        option1.setOnClickListener(onOptionSelected)
        option2.setOnClickListener(onOptionSelected)
        option3.setOnClickListener(onOptionSelected)
        option4.setOnClickListener(onOptionSelected)
    }

    private fun getQuestions(questionIndex: Int) {
        if (questionIndex in 0 until questionsArray.length()) {
            val question = questionsArray.getJSONObject(questionIndex)
            questionText.text = question.getString("questionText")

            val answerArray = question.getJSONArray("answerArray")
            option1.text = answerArray.getString(0)
            option2.text = answerArray.getString(1)
            option3.text = answerArray.getString(2)
            option4.text = answerArray.getString(3)

            option1.isChecked = false
            option2.isChecked = false
            option3.isChecked = false
            option4.isChecked = false
        }
    }

    private fun loadJSONFromRaw(): String {
        val inputStream = resources.openRawResource(R.raw.questions)
        return inputStream.bufferedReader().use { it.readText() }
    }
}
