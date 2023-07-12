package com.example.donut

sealed class AppDestination(val route: String) {
    object BoardingScreen : AppDestination("boardingScreen")
    object HomeScreen : AppDestination("homeScreen")
    object DetailsScreen : AppDestination("detailsScreen")
}