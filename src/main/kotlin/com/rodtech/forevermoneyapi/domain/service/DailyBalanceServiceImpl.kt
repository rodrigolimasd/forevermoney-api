package com.rodtech.forevermoneyapi.domain.service

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import com.rodtech.forevermoneyapi.domain.gateway.DailyBalanceChainDataGateway
import com.rodtech.forevermoneyapi.domain.input.CreateDailyBalanceChainInput
import org.springframework.stereotype.Service

@Service
class DailyBalanceServiceImpl (
    private val dataGateway: DailyBalanceChainDataGateway
) : DailyBalanceService {
    override fun create(createDailyBalanceChainInput: CreateDailyBalanceChainInput): DailyBalanceChain {
        val last = dataGateway.getLast()
        var dailyBalanceChain = createDailyBalanceChainInput.mapperToDomain(last)
        dailyBalanceChain.recalcBalance()
        dailyBalanceChain = dataGateway.save(dailyBalanceChain)
        return dailyBalanceChain
    }

    override fun getAll() = dataGateway.getAll()

}