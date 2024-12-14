package com.example.daggerhilt

import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor() : CurrencyRepository {
    override fun getCurrencies(): List<CurrencyModels> {
        return listOf(
            CurrencyModels("Dollar", R.drawable.ic_dollar),
            CurrencyModels("Euro", R.drawable.ic_euro),
            CurrencyModels("Ruble", R.drawable.ic_ruble)
        )
    }
}