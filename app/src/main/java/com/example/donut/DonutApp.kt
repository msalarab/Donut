package com.example.donut

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.donut.components.BottomNavBar
import com.example.donut.ui.theme.DonutTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonutApp() {
    DonutTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavBar(navController) }) {
            NavGraph(navHostController = navController, modifier = Modifier.padding(it))
        }
    }
}