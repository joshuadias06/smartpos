package com.terminal.smartpos.presentation.components.header

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.ui.tooling.preview.Preview



@Composable
fun HeaderSection(
    onMenuClick: () -> Unit = {},
    onSyncClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }

            Spacer(modifier = Modifier.width(8.dp))

        }

        IconButton(onClick = onSyncClick) {
            Icon(Icons.Default.Sync, contentDescription = "Sincronizar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderSectionPreview(){
    HeaderSection()
}
