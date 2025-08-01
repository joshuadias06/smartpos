package com.terminal.smartpos.presentation.components.installments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InstallmentsCredit(){

    val iconsColor = Color(0xFF007BFF)

    val installments = listOf(
        InstallmentsCredit("1x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("2x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("3x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("4x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("5x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("6x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("7x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("8x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("9x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("10x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("11x", Icons.Default.CreditCard, 1.0){TODO()},
        InstallmentsCredit("12x", Icons.Default.CreditCard, 1.0){TODO()}
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            installments.forEach { installment ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = installment.icon,
                        contentDescription = installment.countInstallments,
                        tint = iconsColor,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(36.dp)
                    )
                    Text(
                        text = installment.countInstallments,
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "R$ ${installment.value}",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "arrowRight",
                        tint = iconsColor
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InstallmentsCreditPreview(){
    InstallmentsCredit()
}