package com.example.donut.screens.details.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.donut.components.NormalButton
import com.example.donut.components.RoundedButton
import com.example.donut.screens.details.DetailsInteraction
import com.example.donut.screens.details.DetailsUiState
import com.example.donut.ui.theme.Pink90
import com.example.donut.ui.theme.PrimaryText
import com.example.donut.ui.theme.SecondaryText
import com.example.donut.ui.theme.Typography

@Composable
fun DetailsBottomSheetContent(
    state: DetailsUiState,
    detailsInteraction: DetailsInteraction
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp, start = 32.dp, end = 32.dp, bottom = 16.dp)
    ) {
        Text(text = state.title, style = Typography.headlineMedium.copy(color = Pink90))
        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = "About Donut",
            style = Typography.bodyMedium.copy(color = PrimaryText)
        )
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = state.description,
            style = Typography.bodySmall.copy(color = SecondaryText)
        )
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Quantity",
            style = Typography.bodyMedium.copy(color = PrimaryText)
        )
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RoundedButton(
                modifier = Modifier.graphicsLayer(
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    ),
                    shadowElevation = 10f,
                    spotShadowColor = Color.Gray,
                ),
                tintColor = Color.White,
                roundedSize = 12,
                onClick = detailsInteraction::onClickMinusIcon
            ) {

                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "-",
                    style = Typography.bodyLarge.copy(color = Color.Black)
                )
            }

            RoundedButton(
                modifier = Modifier.padding(horizontal = 8.dp),
                roundedSize = 12,
                tintColor = Color.Transparent,
                onClick = {}
            ) {
                Text(modifier = Modifier.padding(horizontal = 16.dp), text = state.quantity.toString())

            }
            RoundedButton(
                roundedSize = 12,
                tintColor = Color.Black,
                onClick = detailsInteraction::onClickPlusIcon
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "+",
                    style = Typography.bodyLarge.copy(color = Color.White)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "€${state.price}",
                style = Typography.headlineMedium
            )
            NormalButton(modifier = Modifier.padding(start = 16.dp), buttonColor = Pink90, textColor = Color.White, text = "Add to Cart") {}
        }

    }
}