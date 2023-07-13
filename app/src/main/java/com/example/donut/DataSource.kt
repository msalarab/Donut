package com.example.donut

import com.example.donut.screens.home.DonutsUiState
import com.example.donut.screens.home.TopOffersDonutUiState

object DataSource {

    val topOffers = listOf(
        TopOffersDonutUiState(image = R.drawable.image_7, title = "Strawberry Wheel", description = "These Baked Strawberry Donuts.", price = 20, discount = 15),
        TopOffersDonutUiState(image = R.drawable.image_7, title = "Chocolate Glaze", description = " A chocolate-flavored donut.", price = 30, discount = 25),
        TopOffersDonutUiState(image = R.drawable.image_7, title = "Jelly Donut", description = "Moist and fluffy baked chocolate donut.", price = 40, discount = 35),
        TopOffersDonutUiState(image = R.drawable.image_7, title = "Old-Fashioned", description = "Moist and fluffy baked chocolate donut.", price = 15, discount = 10),
        TopOffersDonutUiState(image = R.drawable.image_7, title = "Apple Fritter", description = "Moist and fluffy baked chocolate donut.", price = 10, discount = 5),
        TopOffersDonutUiState(image = R.drawable.image_7, title = "Powdered Sugar Donut", description = "A simple donut covered in powdered sugar.", price = 13, discount = 8),
    )

    val donuts = listOf(
        DonutsUiState(image = R.drawable.image_10, title = "Strawberry", price = 20),
        DonutsUiState(image = R.drawable.image_8, title = "Chocolate Glaze", price = 25),
        DonutsUiState(image = R.drawable.image_9, title = "Jelly Donut", price = 21),
        DonutsUiState(image = R.drawable.image_8, title = "Old-Fashioned", price = 15),
        DonutsUiState(image = R.drawable.image_10, title = "Apple Fritter", price = 42),
        DonutsUiState(image = R.drawable.image_9, title = "Powdered", price = 42),
    )
}