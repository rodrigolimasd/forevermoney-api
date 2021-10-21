package com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.mappers

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import com.rodtech.forevermoneyapi.domain.input.CreateDailyBalanceChainInput
import com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.dto.DailyBalanceChainRequest
import com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.dto.DailyBalanceChainResponse
import org.springframework.stereotype.Component

@Component
class DailyBalanceMapperImpl : DailyBalanceMapper {
    override fun mapperToDomain(dailyBalanceChain: DailyBalanceChainRequest) =
        with(dailyBalanceChain) {
            CreateDailyBalanceChainInput(
                date = date,
                income = income,
                expense = expense,
                balanceValue = balanceValue,
                note = note
            )
    }

    override fun mapperToResponse(dailyBalanceChain: DailyBalanceChain) =
        with(dailyBalanceChain){
         DailyBalanceChainResponse(
             id = id!!,
             date = date,
             income = income,
             expense = expense,
             balanceValue = balanceValue,
             note = note
         )
    }
}