package com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1

import com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.dto.DailyBalanceChainRequest
import com.rodtech.forevermoneyapi.domain.service.DailyBalanceService
import com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.dto.DailyBalanceChainResponse
import com.rodtech.forevermoneyapi.infrastruct.resource.dailybalance.v1.mappers.DailyBalanceMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(DailyBalanceResource.BASE_DAILY_BALANCES_PATH)
class DailyBalanceResource(
    val dailyBalanceService: DailyBalanceService,
    val dailyBalanceMapper: DailyBalanceMapper
) {

    companion object {
        const val BASE_DAILY_BALANCES_PATH: String = "/forevermoney/v1/daily-balances"
    }

    @PostMapping
    fun create(@RequestBody dailyBalanceChain: DailyBalanceChainRequest): ResponseEntity<DailyBalanceChainResponse> {
        val dailyBalance = dailyBalanceService.create(dailyBalanceMapper.mapperToDomain(dailyBalanceChain))
        return ResponseEntity.status(HttpStatus.CREATED).body(dailyBalanceMapper.mapperToResponse(dailyBalance))
    }

    @GetMapping
    fun getAll(): ResponseEntity<*> = ResponseEntity.ok(
        dailyBalanceService.getAll().map { dailyBalanceMapper.mapperToResponse(it) })


}