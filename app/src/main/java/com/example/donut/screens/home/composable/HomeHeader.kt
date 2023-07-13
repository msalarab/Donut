package com.example.donut.screens.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.donut.R
import com.example.donut.components.RoundedButton
import com.example.donut.ui.theme.Pink90
import com.example.donut.ui.theme.SecondaryText
import com.example.donut.ui.theme.Typography

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(R.string.let_s_gonuts),
                style = Typography.headlineMedium.copy(color = Pink90)
            )
            Text(
                text = stringResource(R.string.order_your_favourite_donuts_from_here),
                style = Typography.bodyMedium.copy(color = SecondaryText)
            )
        }

        RoundedButton(
            onClick = { }
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_round_search),
                contentDescription = "Search Icon",
                tint = Pink90
            )
        }

    }
}