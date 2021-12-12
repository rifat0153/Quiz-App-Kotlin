package com.example.quiz_app.util

sealed class Screen(val route: String) {
    object  QuizScreen: Screen("quiz_screen")
    object  QuestionScreen: Screen("question_screen")
}
