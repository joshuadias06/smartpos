package com.terminal.smartpos.presentation.components.methods

import androidx.compose.ui.graphics.vector.ImageVector

data class PaymentMethod(val paymentMethod: String, val icon: ImageVector, val onClick: () -> Unit)
