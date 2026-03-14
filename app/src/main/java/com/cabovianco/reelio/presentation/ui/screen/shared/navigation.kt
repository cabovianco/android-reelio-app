package com.cabovianco.reelio.presentation.ui.screen.shared

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.cabovianco.reelio.R
import com.cabovianco.reelio.presentation.navigation.Screen

sealed class NavigationItem(
    val route: String,
    @param:DrawableRes val icon: Int
) {
    data object Search : NavigationItem(route = Screen.SearchScreen.route, icon = R.drawable.search)

    data object Bookmark :
        NavigationItem(route = Screen.BookmarkScreen.route, icon = R.drawable.bookmark)
}

private val items = listOf(
    NavigationItem.Search,
    NavigationItem.Bookmark
)

@Composable
fun NavigationBar(currentRoute: String, navigate: (String) -> Unit, modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier) {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.route == currentRoute,
                onClick = { navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null
                    )
                }
            )
        }
    }
}
