package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private val quizViewModel: QuizViewModel by viewModels<QuizViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result = intent.getIntExtra(KEY_RESULT, 0)
        val counter = intent.getIntExtra(KEY_COUNTER, 0)
        val question = quizViewModel.getQuestion(counter)
        val onClick: View.OnClickListener = View.OnClickListener { view: View ->
            // another variable to allow to return back and select another answer
            val res = if (view.tag.toString().toInt() == question.numberOfCorrectAnswer) {
                result + 100
            } else { result }
            if (counter < 4) {
                val intent = Intent(this@QuizActivity, QuizActivity::class.java).apply {
                    putExtra(KEY_COUNTER, counter + 1)
                    putExtra(KEY_RESULT, res)
                }
                startActivity(intent)
            } else {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra(KEY_RESULT, res)
                }
                startActivity(intent)
            }
        }
        binding.apply {
            questionTV.text = question.question
            firstRB.text = question.answers[0]
            firstRB.setOnClickListener(onClick)
            secondRB.text = question.answers[1]
            secondRB.setOnClickListener(onClick)
            thirdRB.text = question.answers[2]
            thirdRB.setOnClickListener(onClick)
        }
    }

    companion object {
        const val KEY_COUNTER = "key counter"
        const val KEY_RESULT = "key result"
    }
}