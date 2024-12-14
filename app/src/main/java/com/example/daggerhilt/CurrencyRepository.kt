package com.example.daggerhilt

interface CurrencyRepository {
    fun getCurrencies(): List<CurrencyModels>
}