package com.terminal.smartpos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.terminal.smartpos.presentation.theme.SmartposTheme
import com.terminal.smartpos.presentation.screens.charge.ChargeScreen

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartposTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ChargeScreen()
                }
            }
        }
    }
}
