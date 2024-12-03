package com.example.quiz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.databinding.ActivityResultBinding
import java.util.Locale

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result = intent.getIntExtra(QuizActivity.KEY_RESULT, 0)
        binding.apply {
            val grade = when (result) {
                100 -> getString(R.string.bad)
                200 -> getString(R.string.unsatisfactory)
                300 -> getString(R.string.satisfactory)
                400 -> getString(R.string.good)
                500 -> getString(R.string.excellent)
                else -> getString(R.string.not_russian)
            }
            resultTV.text = String.format(Locale.getDefault(), getString(R.string.result), result.toString())
            gradeTV.text = String.format(Locale.getDefault(), getString(R.string.grade), grade)
        }
    }
}