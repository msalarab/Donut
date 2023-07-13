package com.example.donut.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.donut.R
import com.example.donut.components.BottomSheet
import com.example.donut.components.FavoriteButtonAnimation
import com.example.donut.components.RoundedButton
import com.example.donut.screens.details.composable.DetailsBottomSheetContent
import com.example.donut.ui.theme.Pink30
import com.example.donut.ui.theme.Pink90

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state by viewModel.state.collectAsState()
    DetailsContent(state, { navHostController.popBackStack() }, viewModel)
}

@Composable
fun DetailsContent(
    state: DetailsUiState,
    onBackClick: () -> Unit,
    detailsInteraction: DetailsInteraction
) {
    Box(
        Modifier
            .background(Pink30)
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onBackClick() }
                    .padding(4.dp),
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = "",
                tint = Pink90,
            )
        }
        Image(
            modifier = Modifier
                .scale(1.2f)
                .padding(top = 80.dp)
                .align(Alignment.TopCenter),
            painter = painterResource(id = R.drawable.image_7),
            contentDescription = ""
        )

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {

            BottomSheet(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                DetailsBottomSheetContent(state, detailsInteraction)
            }


            FavoriteButtonAnimation(
                modifier = Modifier.align(Alignment.TopEnd).padding(end = 8.dp).offset(y = (-30).dp),
                iconState = state.favorite,
                roundedSize = 12,
                onClickIconFavorite = detailsInteraction::onClickCardFavoriteIcon
            )
        }

    }
}
