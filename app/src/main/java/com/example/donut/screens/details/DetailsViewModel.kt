package com.example.donut.screens.details

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donut.DataSource
import com.example.donut.ui.theme.BlueCard
import com.example.donut.ui.theme.Pink30
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(), DetailsInteraction {

    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()

    private val args = DetailsArgs(savedStateHandle)

    init {
        val id = args.id.toString().toInt()
        DataSource.topOffers.mapIndexed { index, topOffersDonutUiState ->
            if (id == index) {
                _state.update {
                    it.copy(
                        image = topOffersDonutUiState.image,
                        title = topOffersDonutUiState.title,
                        description = topOffersDonutUiState.description,
                        price = topOffersDonutUiState.discount,
                        backgroundColor = if (index % 2 != 0) BlueCard else Pink30,
                        favorite = topOffersDonutUiState.favoriteIcon
                    )
                }
            }
        }
    }

    override fun onClickCardFavoriteIcon() {
        _state.update { it.copy(favorite = !_state.value.favorite) }
    }

    override fun onClickPlusIcon() {
        val discount = DataSource.topOffers[args.id.toString().toInt()].discount
        _state.update {
            it.copy(
                quantity = _state.value.quantity + 1,
                price = _state.value.price + discount
            )
        }
    }

    override fun onClickMinusIcon() {
        val discount = DataSource.topOffers[args.id.toString().toInt()].discount
        _state.update {
            it.copy(
                quantity = if (_state.value.quantity > 0) _state.value.quantity - 1 else return,
                price = _state.value.price - discount
            )
        }
    }
}