package com.example.donut.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.donut.ui.theme.Pink30

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    roundedSize: Int = 8,
    tintColor : Color = Pink30,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(roundedSize.dp))
            .background(tintColor)
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        content()
    }
}