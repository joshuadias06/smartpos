package com.terminal.smartpos.presentation.components.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StoreSelectorSection(
    storeName: String,
    onSwitchStore: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = storeName,
            fontSize = 26.sp,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.weight(1f)
        )

        TextButton(
            onClick = onSwitchStore,
            colors = ButtonDefaults.textButtonColors(
            contentColor = Color(0xFF007BFF
            )
        )) {
            Text("Trocar",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoreSelectorSectionPreview(){
    StoreSelectorSection(storeName = "Retail Row", onSwitchStore = {})
}
