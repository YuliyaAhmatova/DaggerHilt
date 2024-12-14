package com.example.daggerhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(private val repository: CurrencyRepository) : ViewModel() {

    private val _currencies = MutableLiveData<List<CurrencyModels>>()
    val currencies: LiveData<List<CurrencyModels>> get() = _currencies

    fun loadCurrencies() {
        _currencies.value = repository.getCurrencies()
    }
}