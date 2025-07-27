package com.terminal.smartpos.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NumericKeyboard(
    onKeyPress: (String) -> Unit
) {
    val keys = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("DEL", "0", "OK")
    )

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        keys.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { key ->

                    val buttonModifier = when (key) {
                        "DEL" -> Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .pointerInput(Unit) {
                                while (true) {
                                    awaitPointerEventScope {
                                        val down = awaitPointerEvent().changes.firstOrNull()
                                        if (down?.pressed == true) {
                                            val job = coroutineScope.launch {
                                                delay(700)
                                                onKeyPress("CLEAR_ALL")
                                            }

                                            while (down.pressed) {
                                                val next = awaitPointerEvent().changes.firstOrNull()
                                                if (next?.pressed == false) {
                                                    job.cancel()
                                                    break
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        else -> Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    }

                    Button(
                        onClick = {
                            if (key == "DEL") {
                                onKeyPress("DEL")
                            } else {
                                onKeyPress(key)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when (key) {
                                "OK" -> Color(0xFF007BFF)
                                else -> Color(0xFFF7F7F7)
                            },
                            contentColor = when (key) {
                                "OK" -> Color.White
                                else -> Color.Black
                            }
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = buttonModifier
                    ) {
                        when (key) {
                            "DEL" -> Icon(
                                imageVector = Icons.Filled.Backspace,
                                contentDescription = "Delete"
                            )
                            "OK" -> Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = "OK"
                            )
                            else -> Text(
                                text = key,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Light,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }
                }
            }
        }
    }
}
