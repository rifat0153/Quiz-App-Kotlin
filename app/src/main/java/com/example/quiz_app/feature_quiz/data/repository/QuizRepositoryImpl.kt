package com.example.quiz_app.feature_quiz.data.repository

import com.example.quiz_app.feature_quiz.data.remote.QuizApi
import com.example.quiz_app.feature_quiz.data.remote.dto.QuizDto
import com.example.quiz_app.feature_quiz.domain.repository.QuizRepository
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val api: QuizApi
) : QuizRepository {
    override suspend fun getQuestions(): QuizDto {
        return api.getQuestions(
            amount = 10,
            category = 18,
            difficulty = "easy",
            type = "multiple",
        )
    }

}