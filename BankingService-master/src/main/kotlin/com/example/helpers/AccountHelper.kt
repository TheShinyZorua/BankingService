package com.example.helpers

import com.example.dtos.AccountBalanceDto
import com.example.dtos.AccountBalanceReturn
import com.example.dtos.DepositRequestDto
import com.example.dtos.WithdrawRequestDto
import com.example.models.BankAccount
import javax.inject.Singleton

@Singleton
open class AccountHelper {
    private val bankAccounts: MutableMap<Int, BankAccount>

    // creating an in memory representation of all our bank accounts. Since AccountHelper is a Singleton we are
    // guaranteed that this representation will only be initialized once on app start up
    init {
        // these are just arbitrary initial balances for these 3 bank accounts. Feel free to change around for testing
        // purposes
        mutableMapOf(
            1 to BankAccount(1, 0.0),
            2 to BankAccount(2, 35.0),
            3 to BankAccount(3, -20.0)
        ).also { bankAccounts = it }
    }
    fun getBalanceForAccount(id: Int): AccountBalanceDto {
        return bankAccounts[id]!!.getAccountBalance()
    }
    /**
     * Adds the given deposit amount to a bank account and returns the new balance of that bank account.
     */
    fun depositToAccount(deposit: DepositRequestDto): AccountBalanceDto {
        return updateBankAccountById(deposit.bankAccountId, deposit.amount).getAccountBalance()
    }
    /**
     * Withdraws the given amount from the bank account and returns the new balance of that bank account.
     */
    fun withdrawFromAccount(withdraw: WithdrawRequestDto): AccountBalanceReturn {
        var accountbalance: AccountBalanceDto = updateBankAccountById(withdraw.bankAccountId, withdraw.amount).getAccountBalance()
        return AccountBalanceReturn(accountbalance, withdraw.amount)
    }
    private fun updateBankAccountById(bankAccountId: Int, depositAmount: Double): BankAccount {
        val updatedAccount = bankAccounts[bankAccountId]!!.apply {
            deposit(depositAmount)
        }
        bankAccounts[bankAccountId] = updatedAccount
        return BankAccount(bankAccountId!!, bankAccounts[bankAccountId]!!.balance)
    }
}
