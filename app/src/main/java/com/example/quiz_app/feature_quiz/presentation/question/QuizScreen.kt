package com.example.quiz_app.feature_quiz.presentation.question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuizScreen(
    viewModel: QuizViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    val state = viewModel.state.value

    Scaffold {

        when (state) {
            is QuestionListState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is QuestionListState.Error -> {
                Text(text = state.error)
            }

            is QuestionListState.Success -> {
                Column(
                    modifier = Modifier.fillMaxSize(),

                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    state.questionList.map {
                        Text(text = it.question)
                    }
                }
            }
        }
    }
}