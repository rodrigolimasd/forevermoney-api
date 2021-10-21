package com.rodtech.forevermoneyapi.domain.service

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import com.rodtech.forevermoneyapi.domain.input.CreateDailyBalanceChainInput

interface DailyBalanceService {
    fun create(createDailyBalanceChainInput: CreateDailyBalanceChainInput) : DailyBalanceChain
    fun getAll(): List<DailyBalanceChain>
}