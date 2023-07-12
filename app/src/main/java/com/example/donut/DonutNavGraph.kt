package com.example.donut

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.donut.screens.boarding.boardingRoute
import com.example.donut.screens.details.detailsRoute
import com.example.donut.screens.home.homeRoute

@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = AppDestination.BoardingScreen.route
    ) {

        homeRoute(navHostController)

        boardingRoute(navHostController)

        detailsRoute(navHostController)
    }
}