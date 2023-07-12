package com.example.donut.screens.boarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.donut.AppDestination

fun NavGraphBuilder.boardingRoute(navHostController : NavHostController){
    composable(AppDestination.BoardingScreen.route) { BoardingScreen(navHostController) }
}