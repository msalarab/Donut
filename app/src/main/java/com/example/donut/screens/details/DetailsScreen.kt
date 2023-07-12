package com.example.donut.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.donut.ui.theme.Pink30

@Composable
fun DetailsScreen() {
    DetailsContent()
}

@Composable
fun DetailsContent() {
    Box(
        Modifier
            .background(Pink30)
            .fillMaxSize()
    ) {

    }
}
