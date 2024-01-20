package com.issog.coffeeappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.issog.coffeeappcompose.model.Menu
import com.issog.coffeeappcompose.model.dummyBestSellerMenu
import com.issog.coffeeappcompose.model.dummyCategory
import com.issog.coffeeappcompose.model.dummyMenu
import com.issog.coffeeappcompose.ui.component.CategoryItem
import com.issog.coffeeappcompose.ui.component.HomeSection
import com.issog.coffeeappcompose.ui.component.MenuItem
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
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Banner()

        //Named parameter usage
        HomeSection(
            title = stringResource(id = R.string.section_category),
            content =  { CategoryRow() }
        )

        //Argument parameter usage
        HomeSection(stringResource(id = R.string.section_favorite_menu), Modifier, {
                MenuRow(listMenu = dummyMenu)
        })

        //Lambda argument usage
        HomeSection(title = stringResource(id = R.string.section_best_seller_menu)) {
            MenuRow(listMenu = dummyBestSellerMenu)
        }
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

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(dummyCategory, key = { it.textCategory }) {category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu = menu)
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_2)
@Composable
fun CoffeeAppPreview() {
    CoffeeappcomposeTheme {
        CoffeeApp()
    }
}