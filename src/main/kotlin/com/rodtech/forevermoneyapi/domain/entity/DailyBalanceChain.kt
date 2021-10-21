package com.rodtech.forevermoneyapi.domain.entity

import java.math.BigDecimal
import java.time.LocalDate

data class DailyBalanceChain(
    var id: String? = null,
    var date: LocalDate,
    var income: BigDecimal = BigDecimal.ZERO,
    var expense: BigDecimal = BigDecimal.ZERO,
    var balanceValue: BigDecimal,
    var note: String? = null,
    var next: DailyBalanceChain? = null,
    val last: DailyBalanceChain? = null
) {
    override fun toString(): String {
        return "{'date': '$date','income':$income," +
                "'expense':$expense, 'balanceValue':$balanceValue," +
                "'note:'$note'}"
    }
}
