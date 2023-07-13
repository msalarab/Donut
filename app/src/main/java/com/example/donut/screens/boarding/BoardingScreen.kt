package com.example.donut.screens.boarding

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.donut.R
import com.example.donut.components.NormalButton
import com.example.donut.screens.home.navigateToHomeScreen
import com.example.donut.ui.theme.Pink30
import com.example.donut.ui.theme.Pink60
import com.example.donut.ui.theme.Pink90
import com.example.donut.ui.theme.Typography

@Composable
fun BoardingScreen(navController: NavHostController) {
    BoardingContent {
        navController.navigateToHomeScreen()
    }
}

@Composable
fun BoardingContent(
    navToHomeScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Pink30)
    ) {
        val transition = rememberInfiniteTransition()
        val offsetY by transition.animateFloat(
            initialValue = -10f,
            targetValue = 10f,
            animationSpec = infiniteRepeatable(
                animation = tween(5000),
                repeatMode = RepeatMode.Reverse
            )
        )

        val offsetX by transition.animateFloat(
            initialValue = -20f,
            targetValue = 10f,
            animationSpec = infiniteRepeatable(
                animation = tween(5000),
                repeatMode = RepeatMode.Reverse
            )
        )

        Image(
            modifier = Modifier
                .size(400.dp)
                .padding(top = 64.dp)
                .offset(x = offsetX.dp, y = offsetY.dp)
                .align(Alignment.TopCenter)
                .scale(1.8f),
            painter = painterResource(id = R.drawable.donuts),
            contentDescription = "donuts"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(R.string.boarding_gounts),
                style = Typography.headlineLarge.copy(color = Pink90)
            )
            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 60.dp),
                text = stringResource(R.string.boarding_details),
                style = Typography.bodyMedium.copy(color = Pink60)
            )
            NormalButton(text = "Get Started") { navToHomeScreen() }
        }
    }
}