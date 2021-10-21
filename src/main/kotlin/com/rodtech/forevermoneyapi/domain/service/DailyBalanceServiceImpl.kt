package com.rodtech.forevermoneyapi.domain.service

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import com.rodtech.forevermoneyapi.domain.gateway.DailyBalanceChainDataGateway
import com.rodtech.forevermoneyapi.domain.input.CreateDailyBalanceChainInput
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class DailyBalanceServiceImpl (
    private val dataGateway: DailyBalanceChainDataGateway
) : DailyBalanceService {
    override fun create(createDailyBalanceChainInput: CreateDailyBalanceChainInput): DailyBalanceChain {
        val last = dataGateway.getLast()
        var dailyBalanceChain = createDailyBalanceChainInput.mapperToDomain(last)
        calcBalance(dailyBalanceChain)
        val dailyBalanceChainDb = dataGateway.save(dailyBalanceChain)
        dailyBalanceChain.id = dailyBalanceChainDb.id
        return dailyBalanceChain
    }

    override fun getAll() = dataGateway.getAll()

    private fun calcBalance(dailyBalanceChain: DailyBalanceChain) {
        var balance = BigDecimal.ZERO
        if (dailyBalanceChain.last != null) {
            balance = balance.add(dailyBalanceChain.last.balanceValue)
        }
        balance = balance.add(dailyBalanceChain.income).subtract(dailyBalanceChain.expense)
        dailyBalanceChain.next?.balanceValue = balance
        dailyBalanceChain.balanceValue = balance
    }

    private fun recalcBalance(dailyBalanceChain: DailyBalanceChain) {
        calcBalance(dailyBalanceChain)
        dailyBalanceChain.next?.let{ recalcBalance(it)}
    }

}