package com.example.controllers

import com.example.dtos.AccountBalanceDto
import com.example.dtos.AccountBalanceReturn
import com.example.dtos.DepositRequestDto
import com.example.dtos.WithdrawRequestDto
import com.example.helpers.AccountHelper
import io.micronaut.context.annotation.Context
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/accounts")
@Context
class AccountController(
    private val accountHelper: AccountHelper
) {
    /**
     * Defines an HTTP GET route to get information about a user's current balance given a bank account id
     */
    @Get("/{id}")
    fun getAccountBalance(@PathVariable id: Int): HttpResponse<AccountBalanceDto> {
        val accountBalance = accountHelper.getBalanceForAccount(id);
        return HttpResponse.ok(accountBalance)
    }

    /**
     * Defines an HTTP POST route to deposit money into a bank account. Returns an AccountBalanceDto with information
     * about the updated balance
     */
    @Post(consumes = [MediaType.APPLICATION_JSON])
    fun deposit(@Body deposit: DepositRequestDto): HttpResponse<AccountBalanceDto> {
        val newAccountBalance = accountHelper.depositToAccount(deposit)
        return HttpResponse.ok(newAccountBalance)
    }

    @Post(consumes = [MediaType.APPLICATION_JSON])
    fun withdraw(@Body withdraw: WithdrawRequestDto): HttpResponse<AccountBalanceReturn> {
        val newAccountBalance = accountHelper.withdrawFromAccount(withdraw)
        return HttpResponse.ok(newAccountBalance)}
}
