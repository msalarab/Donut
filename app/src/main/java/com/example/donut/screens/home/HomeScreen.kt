package com.example.donut.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.donut.AppDestination
import com.example.donut.R
import com.example.donut.screens.details.navigateToDetailsScreen
import com.example.donut.screens.home.composable.DonutsHomeCard
import com.example.donut.screens.home.composable.HomeHeader
import com.example.donut.screens.home.composable.TopOffersDonutHomeCard
import com.example.donut.ui.theme.Background
import com.example.donut.ui.theme.Pink90
import com.example.donut.ui.theme.Typography

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state, viewModel, navHostController)
}

@Composable
fun HomeContent(
    state: HomeUiState,
    homeInteraction: HomeInteraction,
    navHostController: NavHostController
) {

        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Background),
            contentPadding = PaddingValues(top= 32.dp, bottom = 16.dp)
        ) {

            item {
                HomeHeader(modifier = Modifier.padding(horizontal = 16.dp))
            }

            item {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = stringResource(R.string.today_offers),
                    style = Typography.bodyLarge
                )
            }
            item {
                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    itemsIndexed(state.topOffers) { index, item ->
                        TopOffersDonutHomeCard(state = state.topOffers[index],
                            onClickCard = { navHostController.navigateToDetailsScreen(index) },
                            onClickIconFavorite = { homeInteraction.onClickCardFavoriteIcon(index) })
                    }
                }
            }

            item {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = stringResource(R.string.donuts),
                    style = Typography.bodyLarge
                )
            }

            item {
                LazyRow(
                    contentPadding = PaddingValues(top = 32.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    itemsIndexed(state.donuts) { index, item ->
                        DonutsHomeCard(state = state.donuts[index])
                    }
                }
            }

    }
}