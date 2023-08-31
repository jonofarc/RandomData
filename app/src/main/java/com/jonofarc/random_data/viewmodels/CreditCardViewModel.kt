package com.jonofarc.random_data.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonofarc.random_data.model.CreditCard
import com.jonofarc.random_data.model.CreditCardRepository
import kotlinx.coroutines.launch

class CreditCardViewModel : ViewModel() {
    private val repository = CreditCardRepository()

    private val _creditCards = MutableLiveData<List<CreditCard>>()
    val creditCards: LiveData<List<CreditCard>> = _creditCards

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getCreditCards()
                _creditCards.value = cards
            } catch (e: Exception) {
                // Handle error
                Log.d("jon", "an error ocurred $e")
            }
        }
    }
}