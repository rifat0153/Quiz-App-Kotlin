package com.example.quiz_app.feature_quiz.domain.repository

import com.example.quiz_app.feature_quiz.data.remote.dto.QuizDto

interface QuizRepository {
    suspend fun getQuestions(): QuizDto
}