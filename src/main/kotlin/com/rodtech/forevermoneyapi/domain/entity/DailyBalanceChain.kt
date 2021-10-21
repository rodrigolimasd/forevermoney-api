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
    private fun calcBalance(): BigDecimal {
        var balance = BigDecimal.ZERO
        balance = balance.add(balanceValue).add(income).subtract(expense)
        next?.balanceValue = balance
        return balance
    }

    fun recalcBalance() {
        if (last != null) {
            balanceValue = last.balanceValue
        } else {
            balanceValue = BigDecimal.ZERO
        }
        balanceValue = calcBalance()
        next?.recalcBalance()
    }

    fun updateIncome(incomeUpdate: BigDecimal) {
        income = incomeUpdate
        recalcBalance()
    }

    fun updateExpense(updateExpense: BigDecimal) {
        expense = updateExpense
        recalcBalance()
    }

    override fun toString(): String {
        return "{'date': '$date','income':$income," +
                "'expense':$expense, 'balanceValue':$balanceValue," +
                "'note:'$note'}"
    }

    init {
        balanceValue = calcBalance()
        if(last!=null){
            last.next = this
        }
    }


}
