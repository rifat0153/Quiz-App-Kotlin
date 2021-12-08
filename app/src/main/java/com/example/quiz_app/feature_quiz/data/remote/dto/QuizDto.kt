package com.example.quiz_app.feature_quiz.data.remote.dto


import com.google.gson.annotations.SerializedName

data class QuizDto(
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("results")
    val results: List<QuestionDetailDto>
)