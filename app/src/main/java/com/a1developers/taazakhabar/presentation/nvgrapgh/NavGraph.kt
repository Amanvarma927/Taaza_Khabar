package com.a1developers.taazakhabar.presentation.nvgrapgh

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.a1developers.taazakhabar.presentation.bookmark.BookmarkScreen
import com.a1developers.taazakhabar.presentation.bookmark.BookmarkViewModel
import com.a1developers.taazakhabar.presentation.news_naivgator.components.NewsNavigator
import com.a1developers.taazakhabar.presentation.onboarding.OnBoardingViewModel
import com.a1developers.taazakhabar.presentation.onboarding.onBoardingScreen

@Composable
fun NavGraph(
    startDestination: String,
){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(route = Route.OnBoardingScreen.route){

                    val viewModel: OnBoardingViewModel = hiltViewModel()
                onBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {

            composable(route = Route.NewsNavigatorScreen.route) {

                NewsNavigator()
            }
        }
    }
}
