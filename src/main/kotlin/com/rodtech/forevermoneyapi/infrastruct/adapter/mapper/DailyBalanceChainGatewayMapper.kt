package com.rodtech.forevermoneyapi.infrastruct.adapter.mapper

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import com.rodtech.forevermoneyapi.infrastruct.entitymodel.DailyBalanceChainEntity

interface DailyBalanceChainGatewayMapper {
    fun mapperToDomain(dailyBalanceChainEntity: DailyBalanceChainEntity): DailyBalanceChain
    fun mapperToEntity(dailyBalanceChain: DailyBalanceChain): DailyBalanceChainEntity
}