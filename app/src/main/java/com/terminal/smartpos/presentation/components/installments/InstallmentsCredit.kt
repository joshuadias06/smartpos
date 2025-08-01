package com.terminal.smartpos.presentation.components.installments

import androidx.compose.ui.graphics.vector.ImageVector

data class InstallmentsCredit(val countInstallments: String, val icon: ImageVector, val value: Double, val onClick: () -> Unit)
