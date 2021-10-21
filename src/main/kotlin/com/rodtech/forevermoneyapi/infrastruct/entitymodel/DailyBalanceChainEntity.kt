package com.rodtech.forevermoneyapi.infrastruct.entitymodel

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Document
data class DailyBalanceChainEntity (
    @Id
    val id: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val date: LocalDate,
    val income: BigDecimal = BigDecimal.ZERO,
    val expense: BigDecimal = BigDecimal.ZERO,
    val balanceValue: BigDecimal,
    val note: String? = null,
    @DBRef
    val next: DailyBalanceChainEntity? = null,
    @DBRef
    val last: DailyBalanceChainEntity? = null
)
