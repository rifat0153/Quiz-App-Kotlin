package com.example.quiz_app.feature_quiz.presentation.quiz

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuizScreen(
    viewModel: QuizViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold {
        Text(text = "Hello From Quiz Screen")
    }
}