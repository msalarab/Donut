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
    val price: Int = 0,
    val discount: Int = 0,
)

data class DonutsUiState(
    val image : Int = 0,
    val title : String = "",
    val price: Int = 0,
)

