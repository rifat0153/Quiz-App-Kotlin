package com.example.quiz_app.feature_quiz.data.remote.dto

import com.example.quiz_app.feature_quiz.domain.model.Question
import com.google.gson.annotations.SerializedName

data class QuestionDetailDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("correct_answer")
    val correctAnswer: String,
    @SerializedName("difficulty")
    val difficulty: String,
    @SerializedName("incorrect_answers")
    val incorrectAnswers: List<String>,
    @SerializedName("question")
    val question: String,
    @SerializedName("type")
    val type: String
)

fun QuestionDetailDto.toQuestion(): Question {
    return Question(
        category = category,
        difficulty = difficulty,
        correctAnswer = correctAnswer,
        incorrectAnswers = incorrectAnswers,
        question = question
    )
}