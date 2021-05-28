package com.example.dtos

data class AccountBalanceDto(
    var accountId: Int,
    var balance: Double,
    var formattedBalance: String? = null
)
