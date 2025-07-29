package com.terminal.smartpos.presentation.components.utils

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CancelButton(
    onSwitchStore: () -> Unit
){

    TextButton(
        onClick = onSwitchStore,
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color(0xFFEF0000)
        )) {
        Text("Cancelar",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CancelButtonPreview(){
    CancelButton( onSwitchStore = { TODO()})
}