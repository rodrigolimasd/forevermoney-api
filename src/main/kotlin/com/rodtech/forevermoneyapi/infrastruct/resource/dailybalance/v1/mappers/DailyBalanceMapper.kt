package com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.mappers

import com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.dto.DailyBalanceChainRequest
import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import com.rodtech.forevermoneyapi.domain.input.CreateDailyBalanceChainInput
import com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.dto.DailyBalanceChainResponse

interface DailyBalanceMapper {
    fun mapperToDomain(dailyBalanceChain: DailyBalanceChainRequest): CreateDailyBalanceChainInput
    fun mapperToResponse(dailyBalanceChain: DailyBalanceChain): DailyBalanceChainResponse
}