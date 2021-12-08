package com.example.quiz_app.feature_quiz.domain.model

data class Question(
    val category: String,
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
    val difficulty: String,
)
