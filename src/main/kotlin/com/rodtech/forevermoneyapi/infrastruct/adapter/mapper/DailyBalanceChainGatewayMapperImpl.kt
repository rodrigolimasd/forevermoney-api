package com.rodtech.forevermoneyapi.infrastruct.adapter.mapper

import com.rodtech.forevermoneyapi.domain.entity.DailyBalanceChain
import com.rodtech.forevermoneyapi.infrastruct.entitymodel.DailyBalanceChainEntity
import org.springframework.stereotype.Component

@Component
class DailyBalanceChainGatewayMapperImpl : DailyBalanceChainGatewayMapper {
    override fun mapperToDomain(dailyBalanceChainEntity: DailyBalanceChainEntity) =
        with(dailyBalanceChainEntity) {
            DailyBalanceChain(
                id=id,
                date=date,
                income=income,
                expense=expense,
                balanceValue=balanceValue,
                note=note,
                next=next?.let{
                    DailyBalanceChain(
                        id = it.id,
                        date = it.date,
                        income = it.income,
                        expense = it.expense,
                        balanceValue = it.balanceValue,
                        note = it.note
                    )
                },
                last=last?.let{ DailyBalanceChain(
                        id = it.id,
                        date = it.date,
                        income = it.income,
                        expense = it.expense,
                        balanceValue = it.balanceValue,
                        note = it.note
                    )
                }

            )
        }

    override fun mapperToEntity(dailyBalanceChain: DailyBalanceChain) =
        with(dailyBalanceChain){
            DailyBalanceChainEntity(
                id=id,
                date=date,
                income=income,
                expense=expense,
                balanceValue=balanceValue,
                note=note,
                next=next?.let{
                    DailyBalanceChainEntity(
                        id=it.id,
                        date=it.date,
                        balanceValue=it.balanceValue
                    )
                },
                last=last?.let{
                    DailyBalanceChainEntity(
                        id=it.id,
                        date=it.date,
                        balanceValue=it.balanceValue
                    )
                }
            )
        }

}