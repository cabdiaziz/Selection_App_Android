package com.example.practicalapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry

@Composable
fun SecondScreen(entry: NavBackStackEntry) {
    //val animal = entry.arguments?.getString("animal")
    val name = entry.arguments?.getString("name")
    val bird = painterResource(id = R.drawable.setup)
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        SecondTopBar(bird, name)
        SecondScreenBody()
        Column(
            modifier = Modifier
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MessageCard()
        }
    }
}