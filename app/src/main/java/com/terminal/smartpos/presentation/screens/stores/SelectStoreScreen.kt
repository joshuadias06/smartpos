package com.terminal.smartpos.presentation.screens.stores

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectStoreScreen(
    storeList: List<String> = listOf("Loja A", "Loja B", "Loja C"), // default para preview
    currentStore: String = "",
    onStoreSelected: (String) -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedStore by remember { mutableStateOf(currentStore.ifBlank { storeList.firstOrNull() ?: "" }) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top App Bar
        TopAppBar(
            title = { Text("Selecionar Loja") },
            navigationIcon = {
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar"
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
        )

        Spacer(modifier = Modifier.height(64.dp))

        // Ícone de Loja
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Store,
                contentDescription = "Loja",
                tint = Color.Gray,
                modifier = Modifier.size(96.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Loja Selecionada:", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Box {
                    OutlinedButton(onClick = { expanded = true }) {
                        Text(selectedStore.ifBlank { "Selecionar loja" })
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        storeList.take(10).forEach { store ->
                            DropdownMenuItem(
                                text = { Text(store) },
                                onClick = {
                                    selectedStore = store
                                    expanded = false
                                    onStoreSelected(store)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectStoreScreenPreview() {
    SelectStoreScreen()
}
