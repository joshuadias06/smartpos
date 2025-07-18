package com.terminal.smartpos.core.utils

fun formatAmount(amount: String): String {
    if (amount.isEmpty()) return "0,00"

    val cents = amount.toLongOrNull() ?: return "0,00"

    val reais = cents / 100
    val centavos = cents % 100
    
    return "%,d,%02d".format(reais, centavos)
        .replace(',', 'X')
        .replace('.', ',')
        .replace('X', '.')
}
