package com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.dto

import java.math.BigDecimal
import java.time.LocalDate

data class DailyBalanceChainResponse (
    val id: String,
    val date: LocalDate,
    val income: BigDecimal = BigDecimal.ZERO,
    val expense: BigDecimal = BigDecimal.ZERO,
    val balanceValue: BigDecimal,
    val note: String? = null
)
