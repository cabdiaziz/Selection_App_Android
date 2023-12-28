package com.example.practicalapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // column -> row,  row, row(button)
    // show btn only if the card selected and text-field filled.
    // column -> row, card
    val horse = painterResource(id = R.drawable.horse)
    val bird = painterResource(id = R.drawable.bird)
    Column {

        TopBar() //top bar component
        BodyTextView() // text in the body of the home screen.

        TextInputDesign() //input text design.
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceEvenly, Alignment.CenterVertically){
            AnimalCard(imgSrc=bird)
            AnimalCard(imgSrc=horse)
        }


    }
}
