package com.cabovianco.reelio.presentation.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchDetailScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) {
        SearchDetailScreenContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun SearchDetailScreenContent(modifier: Modifier = Modifier) {

}
