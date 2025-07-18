package com.terminal.smartpos.presentation.screens.charge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.terminal.smartpos.core.utils.formatAmount
import com.terminal.smartpos.presentation.components.HeaderSection
import com.terminal.smartpos.presentation.components.NumericKeyboard
import com.terminal.smartpos.presentation.components.StoreSelectorSection

@Composable
fun ChargeScreen(
    modifier: Modifier = Modifier,
    storeName: String = "Loja Exemplo",
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
            .padding(16.dp)
    ) {
        HeaderSection(onMenuClick = onMenuClick, onSyncClick = onSyncClick)

        StoreSelectorSection(storeName = storeName, onSwitchStore = onSwitchStore)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "R$ ${formatAmount(amountState.value)}",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        NumericKeyboard(
            onKeyPress = { key ->
                when (key) {
                    "OK" -> amountState.value.toIntOrNull()?.let { onConfirmAmount(it) }
                    "DEL" -> amountState.value = amountState.value.dropLast(1)
                    else -> if (amountState.value.length < 9) amountState.value += key
                }
            }
        )
    }
}

