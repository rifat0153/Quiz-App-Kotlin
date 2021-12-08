package com.example.quiz_app.feature_quiz.presentation.quiz

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable

@Composable
fun QuizScreen() {
    val scaffoldState = rememberScaffoldState()

    Scaffold {
        Text(text = "Hello From Quiz Screen")
    }
}