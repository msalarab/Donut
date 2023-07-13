package com.example.donut.screens.details

data class DetailsUiState(
    val image: Int = 0,
    val favorite: Boolean = false,
    val title: String = "",
    val description: String = "",
    val price: Int = 0,
    val quantity: Int = 1
)

