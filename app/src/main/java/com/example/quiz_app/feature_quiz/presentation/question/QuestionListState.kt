package com.example.quiz_app.feature_quiz.presentation.question

import com.example.quiz_app.feature_quiz.domain.model.Question

sealed class QuestionListState {
    data class Success(val questionList: List<Question> = emptyList()) : QuestionListState()
    class Error(val error: String) : QuestionListState()
    object  Loading: QuestionListState()
}
