package com.example.practicalapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimalCard(modifier: Modifier = Modifier, imgSrc: Painter) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(8.dp)
            .size(120.dp, 120.dp)
            .fillMaxSize(1f)
            .shadow(2.dp, shape = RoundedCornerShape(16.dp))
            .clickable { }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color(0xFFDBD1E1), shape = RoundedCornerShape(10.dp))
                .size(140.dp)
                .offset(1.dp, 4.dp)
        ) {
            Image(
                painter = imgSrc,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun TopBar() {
    val imgSrc = painterResource(id = R.drawable.setup)
    Spacer(modifier = Modifier.height(20.dp))
    Row(modifier = Modifier.padding(15.dp)) {
        val smileEmoji = "\uD83D\uDE04"
        Text(
            "Hi there $smileEmoji",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(start = 6.dp)
        )
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = imgSrc,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(32.dp)),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
fun BodyTextView() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            "Let's Learn about you !",
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Light),
            modifier = Modifier.padding(10.dp)
        )
        Text(
            "This app will prepare a details page based on input provided by you !",
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextInputDesign() {
    var textInputValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            "Name",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(start = 15.dp)
        )
        OutlinedTextField(
            value = textInputValue,
            onValueChange = { textInputValue = it },
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
            placeholder = { Text("Enter your name") },
            singleLine = true
        )
        Text(
            "What do you like",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(top = 15.dp, start = 15.dp)
        )
    }
}