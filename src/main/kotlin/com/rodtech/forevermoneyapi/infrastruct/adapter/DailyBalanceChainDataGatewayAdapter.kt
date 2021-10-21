package com.rodtech.forevermoneyapi.infrastruct.adapter

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import com.rodtech.forevermoneyapi.domain.gateway.DailyBalanceChainDataGateway
import com.rodtech.forevermoneyapi.infrastruct.adapter.mapper.DailyBalanceChainGatewayMapper
import com.rodtech.forevermoneyapi.infrastruct.repository.DailyBalanceChainRepository
import org.springframework.stereotype.Component

@Component
class DailyBalanceChainDataGatewayAdapter(
    private val repository: DailyBalanceChainRepository,
    private val mapper: DailyBalanceChainGatewayMapper
) : DailyBalanceChainDataGateway {

    override fun save(dailyBalanceChain: DailyBalanceChain) =
        mapper.mapperToDomain(repository.save(mapper.mapperToEntity(dailyBalanceChain)))

    override fun getAll(): List<DailyBalanceChain> =
        repository.findAll().map { mapper.mapperToDomain(it) }

    override fun getLast(): DailyBalanceChain? =
        repository.findFirstByOrderByDateDescCreatedAtDesc()?.let{ mapper.mapperToDomain(it) }

}