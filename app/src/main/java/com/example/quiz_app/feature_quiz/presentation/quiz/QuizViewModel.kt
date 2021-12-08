package com.example.quiz_app.feature_quiz.presentation.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz_app.common.Resource
import com.example.quiz_app.feature_quiz.domain.usecase.QuizUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val quizUseCases: QuizUseCases
) : ViewModel() {

    private var job: Job? = null

    init {
        quizUseCases.getQuizUseCase().onEach {
            when (it) {
                is Resource.Loading -> Log.d("Quiz", "Loading")
                is Resource.Success -> {
                    it.data?.forEach { question ->
                        Log.d("Quiz", question.question)
                    }
                }
                is Resource.Error -> Log.d(
                    "Quiz",
                    it.message.toString()
                )
            }
        }.launchIn(viewModelScope)
    }

}