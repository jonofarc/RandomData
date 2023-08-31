package com.jonofarc.random_data.model

import com.jonofarc.random_data.services.RetrofitInstance

class CreditCardRepository {
    private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): List<CreditCard> {
        return creditCardService.getCreditCards()
    }
}