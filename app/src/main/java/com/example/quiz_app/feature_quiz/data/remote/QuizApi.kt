package com.example.quiz_app.feature_quiz.data.remote

import com.example.quiz_app.feature_quiz.data.remote.dto.QuizDto
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi {

    @GET("api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String
    ): QuizDto
}
