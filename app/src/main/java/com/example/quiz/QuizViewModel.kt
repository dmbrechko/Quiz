package com.example.quiz

import androidx.lifecycle.ViewModel

class QuizViewModel: ViewModel() {
    fun getQuestion(index: Int): QuestionWithAnswers {
        return when (index) {
            0 -> QuestionWithAnswers(
                0,
                "Who is the first president of Russia?",
                listOf("Gorbachev", "Unknown guy from Pakistan", "Unknown guy from Zimbabwe")
            )

            1 -> QuestionWithAnswers(
                2,
                "Who was the first Russian Tsar from the Romanov dynasty?",
                listOf("Ivan the Terrible", "Peter the Great", "Mikhail Fyodorovich Romanov")
            )

            2 -> QuestionWithAnswers(
                1,
                "When did World War II begin in Russia?",
                listOf(
                    "On September 1, 1939",
                    "On June 22, 1941",
                    "In 1945"
                )
            )
            3 -> QuestionWithAnswers(
                2,
                "What event took place in Russia in 1861?",
                listOf(
                    "The beginning of the Russo-Turkish War",
                    "The establishment of serfdom",
                    "The Emancipation Reform"
                )
            )
            4 -> QuestionWithAnswers(
                1,
                "In what year did the Chernobyl nuclear power plant accident occur?",
                listOf(
                    "In 1979",
                    "In 1986",
                    "In 2000"
                )
            )
            else -> throw IllegalArgumentException("Only five questions in this quiz")
        }
    }
}

class QuestionWithAnswers(
    val numberOfCorrectAnswer: Int,
    val question: String,
    val answers: List<String>
) {
}