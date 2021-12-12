package com.example.quiz_app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz_app.feature_quiz.presentation.question.QuizScreen
import com.example.quiz_app.ui.theme.QuizAppTheme
import com.example.quiz_app.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuizAppTheme {
                Surface(
                    color = MaterialTheme.colors.onSurface
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.QuizScreen.route
                    ) {

                        composable(route = Screen.QuizScreen.route) {
                            QuizScreen()
                        }




                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizAppTheme {
        Greeting("Android")
    }
}