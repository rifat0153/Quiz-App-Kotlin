package com.example.quiz_app.di

import com.example.quiz_app.common.Constants
import com.example.quiz_app.feature_quiz.data.remote.QuizApi
import com.example.quiz_app.feature_quiz.data.repository.QuizRepositoryImpl
import com.example.quiz_app.feature_quiz.domain.repository.QuizRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQuizApi(): QuizApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().create())
            )
            .build()
            .create(QuizApi::class.java)
    }

    @Provides
    @Singleton
    fun providerQuizRepository(api: QuizApi): QuizRepository {
        return QuizRepositoryImpl(api = api)
    }


}