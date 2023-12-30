package com.example.practicalapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController, entry: NavBackStackEntry) {
    //val animal = entry.arguments?.getString("animal")
    val name = entry.arguments?.getString("name")
    val bird = painterResource(id = R.drawable.setup)
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        SecondTopBar(bird, name)
        SecondScreenBody()
        Column(
            modifier = Modifier.fillMaxSize(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MessageCard()
        }
    }
}