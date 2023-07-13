package com.example.donut.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.donut.AppDestination

private val ROUTE = AppDestination.DetailsScreen.route

fun NavController.navigateToDetailsScreen(id : Int) {
    navigate("$ROUTE/$id")
}

fun NavGraphBuilder.detailsRoute(navHostController: NavHostController) {
    composable(
        "$ROUTE/{${DetailsArgs.ARG_ID}}",
        arguments = listOf(
            navArgument(DetailsArgs.ARG_ID) { NavType.IntType }
        )
    ) { DetailsScreen(navHostController = navHostController) }
}

class DetailsArgs(savedStateHandle: SavedStateHandle) {
    val id = checkNotNull(savedStateHandle[ARG_ID])

    companion object {
        const val ARG_ID = "id"
    }
}