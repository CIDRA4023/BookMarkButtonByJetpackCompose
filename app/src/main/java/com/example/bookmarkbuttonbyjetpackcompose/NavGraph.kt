package com.example.bookmarkbuttonbyjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookmarkbuttonbyjetpackcompose.ui.theme.BookMarkButtonByJetpackComposeTheme

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    BookMarkButtonByJetpackComposeTheme {
        NavHost(navController = navController, startDestination = "main") {

            composable("main") { MainScreen(navController = navController) }

            composable("detail") { DetailScreen(navController = navController) }
        }
    }
}