@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.practicalapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(Screen.Second.route + "/{message}" + "/{sender}",
                    arguments = listOf(
                        navArgument("message") { type = NavType.StringType },
                        navArgument("sender") { type = NavType.StringType }
                    )
                ) { entry ->
                    SecondScreen(
                        navController = navController,
                        entry = entry
                    )
                }
            }
        }
    }
}


//snackbar showing
//@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyAppContentWithSnackBar() {
    val scope = rememberCoroutineScope()
    var myValueTextState by remember {
        mutableStateOf("")
    }
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            TextField(
                value = myValueTextState,
                onValueChange = { myValueTextState = it },
                label = { Text("username") },
                singleLine = true,
                modifier = Modifier
            )
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Welcome Abdiaziz",
                            withDismissAction = false,
                            duration = SnackbarDuration.Indefinite
                        )
                    }
                }, modifier = Modifier
                    .align(alignment = Alignment.End)
                    .padding(15.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "SignUp",
                    style = TextStyle(fontWeight = FontWeight(700), fontSize = 19.sp)
                )
            }
        }
    }
}
