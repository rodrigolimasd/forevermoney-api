package com.rodtech.forevermoneyapi.domain.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate

internal class DailyBalanceChainTest {

    @Test
    fun testChainBalace(){
        val eventOne = getChainBalance(
            LocalDate.of(2021, 9, 1),
            BigDecimal.valueOf(1000L),
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            "Initial income"
        )
        val eventTwo = getChainBalance(
            LocalDate.of(2021, 9, 7),
            BigDecimal.ZERO,
            BigDecimal.valueOf(100L),
            eventOne.balanceValue,
            "event expense",
            last = eventOne
        )
        assertEquals(900L, eventTwo.balanceValue.longValueExact())
    }

    @Test
    fun testChainBalanceTwo(){
        val eventOne = getChainBalance(
            LocalDate.of(2021, 9, 1),
            BigDecimal.valueOf(1000L),
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            "Initial income"
        )
        val eventTwo = getChainBalance(
            LocalDate.of(2021, 9, 7),
            BigDecimal.ZERO,
            BigDecimal.valueOf(100L),
            eventOne.balanceValue,
            "event expense",
            last = eventOne
        )
        val eventThree = getChainBalance(
            LocalDate.of(2021, 9, 7),
            BigDecimal.ZERO,
            BigDecimal.valueOf(100L),
            eventTwo.balanceValue,
            "event expense",
            last = eventTwo
        )
        eventTwo.updateIncome(BigDecimal.TEN)
        assertEquals(810L, eventThree.balanceValue.longValueExact())

    }

    @Test
    fun testChainBalanceThree(){
        val eventOne = getChainBalance(
            LocalDate.of(2021, 9, 1),
            BigDecimal.valueOf(1000L),
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            "Initial income"
        )
        val eventTwo = getChainBalance(
            LocalDate.of(2021, 9, 7),
            BigDecimal.ZERO,
            BigDecimal.valueOf(100L),
            eventOne.balanceValue,
            "event two",
            last = eventOne
        )
        val eventThree = getChainBalance(
            LocalDate.of(2021, 9, 7),
            BigDecimal.ZERO,
            BigDecimal.valueOf(100L),
            eventTwo.balanceValue,
            "event three",
            last = eventTwo
        )
        val eventFour = getChainBalance(
            LocalDate.of(2021, 9, 15),
            BigDecimal.valueOf(100L),
            BigDecimal.ZERO,
            eventTwo.balanceValue,
            "event four",
            last = eventThree
        )
        val eventFive = getChainBalance(
            LocalDate.of(2021, 9, 18),
            BigDecimal.valueOf(100L),
            BigDecimal.ZERO,
            eventTwo.balanceValue,
            "event five",
            last = eventFour
        )
        val eventSix = getChainBalance(
            LocalDate.of(2021, 9, 18),
            BigDecimal.valueOf(100L),
            BigDecimal.ZERO,
            eventTwo.balanceValue,
            "event six",
            last = eventFive
        )
        val eventSeven = getChainBalance(
            LocalDate.of(2021, 9, 18),
            BigDecimal.valueOf(100L),
            BigDecimal.ZERO,
            eventTwo.balanceValue,
            "event seven",
            last = eventSix
        )
        eventTwo.updateIncome(BigDecimal.TEN)
        eventThree.updateIncome(BigDecimal.ONE)
        println(eventOne.toString())
        println(eventTwo.toString())
        println(eventThree.toString())
        println(eventFour.toString())
        println(eventFive.toString())
        println(eventSix.toString())
        println(eventSeven.toString())
        assertEquals(1211L, eventSeven.balanceValue.longValueExact())
    }

    fun getChainBalance(
        date: LocalDate,
        income: BigDecimal = BigDecimal.ZERO,
        expense: BigDecimal = BigDecimal.ZERO,
        balance: BigDecimal,
        note: String? = null,
        last: DailyBalanceChain? = null
    ) = DailyBalanceChain(
        date = date,
        income = income,
        expense = expense,
        balanceValue = balance,
        note = note,
        last = last
    )

}