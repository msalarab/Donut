package com.example.donut.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donut.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(), HomeInteraction {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        _state.update { it.copy(topOffers = DataSource.topOffers, donuts = DataSource.donuts) }
    }

        override fun onClickCardFavoriteIcon(position: Int) {
            val currentState = _state.value
            val updatedTopOffers = currentState.topOffers.mapIndexed { index, donutUiState ->
                if (index == position) {
                    donutUiState.copy(favoriteIcon = !donutUiState.favoriteIcon)
                } else {
                    donutUiState
                }
            }
            val updatedState = currentState.copy(topOffers = updatedTopOffers)
            _state.value = updatedState

    }
}