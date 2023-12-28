package com.example.practicalapp

sealed class Screen(var route : String) {
    object Home : Screen("Home")
    object Second : Screen("Second")

    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach{
                arg -> append("/$arg")
            }
        }
    }
}