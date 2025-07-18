package com.terminal.smartpos.core.utils

import java.text.NumberFormat
import java.util.Locale

fun formatAmount(amount: String): String {
    if (amount.isEmpty()) return "0,00";

    val cents = amount.toLongOrNull() ?: return "0,00";

    val value = cents / 100.0;

    val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"));
    val formatted = formatter.format(value);

    return formatted.replace("R$", "").trim();
}
