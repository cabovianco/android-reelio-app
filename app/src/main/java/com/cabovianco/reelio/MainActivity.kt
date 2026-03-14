package com.cabovianco.reelio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cabovianco.reelio.presentation.navigation.AppNavigation
import com.cabovianco.reelio.presentation.ui.theme.ReelioTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReelioTheme {
                AppNavigation()
            }
        }
    }
}
