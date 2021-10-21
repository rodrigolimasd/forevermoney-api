package com.rodtech.forevermoneyapi.domain.input

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import java.math.BigDecimal
import java.time.LocalDate

data class CreateDailyBalanceChainInput (
    var date: LocalDate,
    var income: BigDecimal = BigDecimal.ZERO,
    var expense: BigDecimal = BigDecimal.ZERO,
    var balanceValue: BigDecimal,
    var note: String? = null
) {
    fun mapperToDomain(last: DailyBalanceChain?) =
        DailyBalanceChain(
            date = date,
            income = income,
            expense = expense,
            balanceValue = balanceValue,
            note = note,
            last = last
        )

}
