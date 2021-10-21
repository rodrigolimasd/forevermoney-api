package com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.dto

import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class DailyBalanceChainRequest (
    @field: NotNull
    var date: LocalDate,
    var income: BigDecimal = BigDecimal.ZERO,
    var expense: BigDecimal = BigDecimal.ZERO,
    @field: NotNull
    var balanceValue: BigDecimal,
    var note: String? = null
)
