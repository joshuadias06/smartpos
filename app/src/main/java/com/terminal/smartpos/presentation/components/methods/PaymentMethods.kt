package com.terminal.smartpos.presentation.components.methods

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethods(){

    val containerBackgroundColor = Color(0xFFF7F7F7)
    val iconsColor = Color(0xFF007BFF)

    val methods = listOf(
        PaymentMethod("Débito", Icons.Default.CreditCard) { /* TODO */ },
        PaymentMethod("Crédito", Icons.Default.CreditCard) { /* TODO */ },
        PaymentMethod("PIX", Icons.Default.Pix) { /* TODO */ },
        PaymentMethod("Voucher", Icons.Default.CreditCard) { /* TODO */ },
        PaymentMethod("QR Code Débito", Icons.Default.QrCode) { /* TODO */ },
        PaymentMethod("QR Code Crédito", Icons.Default.QrCode) { /* TODO */ },
    )

    Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Forma de Pagamento",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(10.dp))
                methods.forEach { method ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(vertical = 4.dp)
                    ) {
                        Icon(
                            imageVector = method.icon,
                            contentDescription = method.paymentMethod,
                            tint = iconsColor,
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(36.dp)
                        )
                        Text(
                            text = method.paymentMethod,
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier

                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = " arrowRight",
                            tint = iconsColor,
                            modifier = Modifier.Alignment.CenterEnd
                        )
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun PaymentMethodPreview(){
    PaymentMethods()
}