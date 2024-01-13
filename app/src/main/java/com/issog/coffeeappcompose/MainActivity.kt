package com.issog.coffeeappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.issog.coffeeappcompose.ui.component.Search
import com.issog.coffeeappcompose.ui.theme.CoffeeappcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeappcomposeTheme {
                // A surface container using the 'background' color from the theme
                CoffeeApp()
            }
        }
    }
}

@Composable
fun CoffeeApp() {
    Column {
        Banner()
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun CoffeeAppPreview() {
    CoffeeappcomposeTheme {
        CoffeeApp()
    }
}