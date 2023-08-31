package com.jonofarc.random_data.views

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jonofarc.random_data.ui.theme.RandomDataTheme
import com.jonofarc.random_data.viewmodels.CreditCardViewModel
import kotlin.properties.ReadOnlyProperty





class MainActivity : ComponentActivity() {

    private val viewModel: CreditCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            RandomDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CreditCardScreen(viewModel)
                }
            }
        }
    }


}



@Preview(showBackground = true)
@Composable

fun GreetingPreview() {
    val viewModel = CreditCardViewModel()
    RandomDataTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            CreditCardScreen(viewModel)
        }
    }
}