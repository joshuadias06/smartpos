package com.terminal.smartpos

import ChargeScreenWithDrawer
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.terminal.smartpos.presentation.theme.SmartposTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartposTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ChargeScreenWithDrawer()
                }
            }
        }
    }
}
