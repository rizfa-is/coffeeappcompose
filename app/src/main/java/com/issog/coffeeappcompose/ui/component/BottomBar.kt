package com.issog.coffeeappcompose.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.issog.coffeeappcompose.R
import com.issog.coffeeappcompose.model.BottomBarItem

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navigationItem = listOf(
            BottomBarItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            BottomBarItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            )
        )

        navigationItem.map {
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                label = {
                    Text(text = it.title)
                },
                selected = it.title == navigationItem[0].title,
                onClick = { },
            )
        }
    }
}