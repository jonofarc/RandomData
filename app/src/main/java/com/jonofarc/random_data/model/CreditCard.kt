package com.jonofarc.random_data.model

import com.google.gson.annotations.SerializedName

data class CreditCard(
    @SerializedName("id"                      ) var id                   : Int?    = null,
    @SerializedName("uid"                     ) var uid                  : String? = null,
    @SerializedName("credit_card_number"      ) var creditCardNumber     : String? = null,
    @SerializedName("credit_card_expiry_date" ) var creditCardExpiryDate : String? = null,
    @SerializedName("credit_card_type"        ) var creditCardType       : String? = null

)