package com.example.quiz_app.feature_quiz.presentation.question

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private val _state = mutableStateOf<QuestionListState>(QuestionListState.Loading)
    val state: State<QuestionListState> = _state

    init {
        quizUseCases.getQuizUseCase().onEach {
            when (it) {
                is Resource.Loading -> _state.value = QuestionListState.Loading
                is Resource.Success -> {
                    _state.value = QuestionListState.Success(questionList = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = QuestionListState.Error(
                        error = it.message ?: "Some unexpected error occured"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}