package com.issog.coffeeappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.issog.coffeeappcompose.ui.theme.CoffeeappcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeappcomposeTheme {
                // A surface container using the 'background' color from the theme
                CoffeeApp(name = "Android")
            }
        }
    }
}

@Composable
fun CoffeeApp(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun CoffeeAppPreview() {
    CoffeeappcomposeTheme {
        CoffeeApp("Android")
    }
}