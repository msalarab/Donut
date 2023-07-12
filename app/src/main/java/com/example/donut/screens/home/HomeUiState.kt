package com.example.donut.screens.home

data class HomeUiState(
    val topOffers: List<TopOffersDonutUiState> = emptyList(),
    val donuts: List<DonutsUiState> = emptyList()
)

data class TopOffersDonutUiState(
    var favoriteIcon: Boolean = false,
    val image : Int = 0,
    val title : String = "",
    val description: String = "",
    val price: String = "",
    val discount: String = "",
)

data class DonutsUiState(
    val image : Int = 0,
    val title : String = "",
    val price: String = "",
)

