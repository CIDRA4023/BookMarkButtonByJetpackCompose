package com.example.bookmarkbuttonbyjetpackcompose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookmarkbuttonbyjetpackcompose.ui.detail.DetailViewModel
import com.example.bookmarkbuttonbyjetpackcompose.ui.main.MainViewModel
import com.example.bookmarkbuttonbyjetpackcompose.ui.theme.BookMarkButtonByJetpackComposeTheme

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    BookMarkButtonByJetpackComposeTheme {
        NavHost(navController = navController, startDestination = "main") {

            composable("main") {
                // Navigation＋HiltでViewModelインスタンスを取得するときはhiltViewModel()を使う
                val viewModel= hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, viewModel = viewModel)
            }

            composable("detail") {
                val viewModel= hiltViewModel<DetailViewModel>()
                DetailScreen(navController = navController, viewModel = viewModel)
            }
        }
    }
}