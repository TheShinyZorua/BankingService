package com.example.models

import com.example.dtos.AccountBalanceDto
import java.text.NumberFormat
import java.util.*

/**
 * Class representing a BankAccount object in our system. This is where we store all the necessary data associated with
 * the account
 */
data class BankAccount(
    var id: Int,
    var balance: Double
) {
    /**
     * Adds to the balance of this bank account
     */
    fun deposit(deposit: Double) {
        balance += deposit
    }

    fun withdraw(withdraw: Double) {
        balance -= withdraw
    }
    /**
     * Withdraws from the balance of this bank account
     */
    fun getAccountBalance(): AccountBalanceDto {
        return AccountBalanceDto(
            id,
            balance,
            NumberFormat.getCurrencyInstance(Locale.US).format(balance)
        )
    }
}
