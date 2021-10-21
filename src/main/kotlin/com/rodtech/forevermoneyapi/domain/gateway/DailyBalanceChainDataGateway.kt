package com.rodtech.forevermoneyapi.domain.gateway

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain

interface DailyBalanceChainDataGateway {
    fun save(dailyBalanceChain: DailyBalanceChain) : DailyBalanceChain
    fun getAll() : List<DailyBalanceChain>
    fun getLast() : DailyBalanceChain?
}