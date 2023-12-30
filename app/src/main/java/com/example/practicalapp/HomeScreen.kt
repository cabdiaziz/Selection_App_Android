package com.example.practicalapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val bird = painterResource(id = R.drawable.bird)

    Column {
        TopBar() //top bar component
        BodyTextView() // text in the body of the home screen.
        TextInputDesign(navController = navController) //input text design.
        AnimalCard(imgSrc = bird)
        //GoToDetailsButton(navController = navController) //go to second screen button.
    }
}
