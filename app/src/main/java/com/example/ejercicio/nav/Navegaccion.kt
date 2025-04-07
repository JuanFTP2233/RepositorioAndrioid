package com.example.menus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screamA") {
        composable("screamA") { ScreamA(navController) }
        composable("screamB") { ScreamB(navController) }
        composable("screamC") { ScreamC(navController) }
    }
}
