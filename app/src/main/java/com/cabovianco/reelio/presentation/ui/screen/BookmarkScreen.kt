package com.cabovianco.reelio.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cabovianco.reelio.presentation.ui.screen.shared.NavigationBar

@Composable
fun BookmarkScreen(currentRoute: String, navigate: (String) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        bottomBar = { NavigationBar(currentRoute, navigate, modifier = Modifier.fillMaxWidth()) }
    ) {
        BookmarkScreenContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun BookmarkScreenContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = "Bookmark")
    }
}
