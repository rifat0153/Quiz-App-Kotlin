package com.example.quiz_app.feature_quiz.domain.usecase

import com.example.quiz_app.common.Resource
import com.example.quiz_app.feature_quiz.data.remote.dto.toQuestion
import com.example.quiz_app.feature_quiz.domain.model.Question
import com.example.quiz_app.feature_quiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetQuizUseCase @Inject constructor (
    private val repository: QuizRepository
) {
    operator fun invoke(): Flow<Resource<List<Question>>> = flow {

        try {
            emit(Resource.Loading<List<Question>>())
            val questions = repository.getQuestions().results.map {
                it.toQuestion()
            }
            emit(Resource.Success<List<Question>>(data = questions))
        } catch (e: IOException) {
            emit(Resource.Error<List<Question>>(message = e.toString()))
        }

    }
}