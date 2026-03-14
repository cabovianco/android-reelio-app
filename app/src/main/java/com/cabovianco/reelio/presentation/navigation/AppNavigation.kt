package com.cabovianco.reelio.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cabovianco.reelio.presentation.ui.screen.BookmarkScreen
import com.cabovianco.reelio.presentation.ui.screen.SearchScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Screen.SearchScreen.route

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.SearchScreen.route
    ) {
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(currentRoute, navigate = { route -> navController.navigateTo(route) })
        }

        composable(route = Screen.SearchDetailScreen.route) {}

        composable(route = Screen.BookmarkScreen.route) {
            BookmarkScreen(currentRoute, navigate = { route -> navController.navigateTo(route) })
        }
    }
}

private fun NavHostController.navigateTo(route: String) {
    if (currentDestination?.route != route) {
        navigate(route)
    }
}
