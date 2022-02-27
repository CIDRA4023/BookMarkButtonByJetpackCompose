package com.example.bookmarkbuttonbyjetpackcompose.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.bookmarkbuttonbyjetpackcompose.R
import com.example.bookmarkbuttonbyjetpackcompose.model.database.Item

private const val emptyItemId = -1
private val emptyItem = Item(
    id = emptyItemId,
    title = ""
)

@Composable
fun DetailScreen(navController: NavController, viewModel: DetailViewModel) {
    val item = viewModel.item.collectAsState(initial = emptyItem)

    Scaffold(
        topBar = { DetailAppBar(navController) },
        content = {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize() ) {
            Text(text = item.value.title)

            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Main")
            }
            Text(text = "DetailScreen")
        }
    })
}

@Composable
fun DetailAppBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                    navController.popBackStack()
                }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
    )
}