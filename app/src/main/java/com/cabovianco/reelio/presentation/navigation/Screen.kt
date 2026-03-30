package com.cabovianco.reelio.presentation.navigation

sealed class Screen(val route: String) {
    data object SearchScreen : Screen("search")

    data object SearchDetailScreen : Screen("search/{id}") {
        fun createRoute(id: Int) = "search/$id"
    }

    data object BookmarkScreen : Screen("bookmark")
}
