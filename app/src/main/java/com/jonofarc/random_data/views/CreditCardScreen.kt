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
    val creditCards by viewModel.creditCards.observeAsState(emptyList())




    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }
    Log.d("jon", "11111111111")
    Log.d("jon", "11111111111")
    Column {
        if (creditCards.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")

            val context = LocalContext.current
            val permissionState = remember { mutableStateOf(false) }

            // This contract handles the result of the permission request
            val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                permissionState.value = isGranted
            }

            Column {
                Text(text = "Internet Permission Example")
                Button(onClick = {
                    // Request the internet permission
                    permissionLauncher.launch(Manifest.permission.INTERNET)
                }) {
                    Text(text = "Request Internet Permission")
                }

                if (permissionState.value) {
                    Text(text = "Internet permission granted!")
                } else {
                    Text(text = "Internet permission not granted.")
                }
            }

        } else {
            // Display the list of credit cards
            LazyColumn {
                items(creditCards) { creditCard ->
                    Text(text = creditCard.id.toString())
                    Text(text = creditCard.uid.toString())
                    Text(text = creditCard.creditCardNumber.toString())
                    Divider() // Add a divider between items
                }
            }
        }
    }
}


