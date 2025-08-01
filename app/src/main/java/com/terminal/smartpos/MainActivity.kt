package com.terminal.smartpos

import ChargeScreenWithDrawer
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.terminal.smartpos.presentation.screens.method.PaymentMethodScreen
import com.terminal.smartpos.presentation.screens.stores.SelectStoreScreen
import com.terminal.smartpos.presentation.theme.SmartposTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartposTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "charge") {
                    composable("charge") {
                        ChargeScreenWithDrawer(navController = navController)
                    }
                    composable("select_store") {
                        SelectStoreScreen(
                            storeList = listOf("Loja A", "Loja B", "Loja C"),
                            currentStore = "Loja A",
                            onStoreSelected = { selectedStore ->
                                // TODO: salvar loja
                                navController.popBackStack()
                            },
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable("payment_methods") {
                        PaymentMethodScreen(navController = navController)
                    }
                }

            }
        }
    }
}
