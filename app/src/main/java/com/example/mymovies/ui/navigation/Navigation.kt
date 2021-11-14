package com.example.mymovies.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.mymovies.ui.screens.detail.DetailScreen
import com.example.mymovies.ui.screens.main.MainScreen

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(NavItem.Main) {
            MainScreen { mediaItem ->
                navController.navigate(NavItem.Detail.createBaseRoute(mediaItem.id))
            }
        }
        composable(NavItem.Detail) { backStackEntry ->
            DetailScreen(
                mediaId = backStackEntry.findArg(NavArg.MediaId),
                onUpClick = { navController.popBackStack()})
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
){
    composable(
        route = navItem.route,
        arguments = navItem.args
    ){
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg) : T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}