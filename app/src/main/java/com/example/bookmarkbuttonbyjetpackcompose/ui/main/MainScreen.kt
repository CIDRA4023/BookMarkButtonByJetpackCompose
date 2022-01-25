package com.example.bookmarkbuttonbyjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bookmarkbuttonbyjetpackcompose.ui.main.MainViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    Scaffold(content = {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize() ) {

            Button(onClick = { navController.navigate("detail") }) {
                Text(text = "Detail")
            }
            Text(text = "MainScreen")
        }
    })
}