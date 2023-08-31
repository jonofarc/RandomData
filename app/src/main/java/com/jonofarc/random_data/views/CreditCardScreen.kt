package com.jonofarc.random_data.views

import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.jonofarc.random_data.viewmodels.CreditCardViewModel

@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel) {
    val creditCard by viewModel.creditCards.observeAsState()


    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }

    Column {
        if (creditCard == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")


        } else {
            Text(text = creditCard?.id.toString())
            Text(text = creditCard?.uid.toString())
            Text(text = creditCard?.creditCardNumber.toString())
            Text(text = creditCard?.creditCardExpiryDate.toString())
            Text(text = creditCard?.creditCardType.toString())
            Divider() // Add a divider between items
        }
    }
}


