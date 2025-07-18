package com.terminal.smartpos.presentation.screens.charge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.terminal.smartpos.core.utils.formatAmount
import com.terminal.smartpos.presentation.components.HeaderSection
import com.terminal.smartpos.presentation.components.NumericKeyboard
import com.terminal.smartpos.presentation.components.StoreSelectorSection

@Composable
fun ChargeScreen(
    modifier: Modifier = Modifier,
    storeName: String = "Retail Row",
    onSwitchStore: () -> Unit = {},
    onConfirmAmount: (Int) -> Unit = {},
    onMenuClick: () -> Unit = {},
    onSyncClick: () -> Unit = {}
) {
    val amountState = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            HeaderSection(onMenuClick = onMenuClick, onSyncClick = onSyncClick)

            Spacer(modifier = Modifier.height(12.dp))

            StoreSelectorSection(storeName = storeName, onSwitchStore = onSwitchStore)

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "R$ ${formatAmount(amountState.value)}",
                    fontSize = 46.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        NumericKeyboard(
            onKeyPress = { key ->
                when (key) {
                    "OK" -> amountState.value.toIntOrNull()?.let { onConfirmAmount(it) }
                    "DEL" -> if (amountState.value.isNotEmpty()) amountState.value = amountState.value.dropLast(1)
                    else -> if (amountState.value.length < 9) amountState.value += key
                }
            }
        )
    }
}
