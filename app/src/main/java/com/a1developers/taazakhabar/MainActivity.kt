package com.a1developers.taazakhabar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.a1developers.taazakhabar.data.local.NewsDao
import com.a1developers.taazakhabar.domain.model.Article
import com.a1developers.taazakhabar.domain.model.Source
import com.a1developers.taazakhabar.ui.theme.TaazaKhabarTheme
import dagger.hilt.android.AndroidEntryPoint
import com.a1developers.taazakhabar.presentation.nvgrapgh.NavGraph
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()
    @Inject
    lateinit var dao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//
        actionBar?.hide()
        enableEdgeToEdge()

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
        }}
        setContent {
            TaazaKhabarTheme {

                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()
                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )}

                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
            }
        }

    }
}}

