package com.jonofarc.random_data.services

import com.jonofarc.random_data.model.CreditCard
import retrofit2.http.GET

interface CreditCardService {
    @GET("credit_cards?size=100")
    suspend fun getCreditCards(): List<CreditCard>
}