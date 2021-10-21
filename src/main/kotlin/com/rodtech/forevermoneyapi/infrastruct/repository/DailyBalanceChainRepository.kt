package com.rodtech.forevermoneyapi.infrastruct.repository

import com.rodtech.forevermoneyapi.infrastruct.entitymodel.DailyBalanceChainEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyBalanceChainRepository : MongoRepository<DailyBalanceChainEntity, String> {
    fun findFirstByOrderByDateDescCreatedAtDesc() : DailyBalanceChainEntity?
}