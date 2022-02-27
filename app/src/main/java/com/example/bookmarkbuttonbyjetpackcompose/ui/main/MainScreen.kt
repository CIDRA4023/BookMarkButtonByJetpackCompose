package com.example.bookmarkbuttonbyjetpackcompose.ui.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.bookmarkbuttonbyjetpackcompose.R
import com.example.bookmarkbuttonbyjetpackcompose.model.database.Item

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val itemList = viewModel.itemList.collectAsState(initial = emptyList())
    Scaffold(
        topBar = { MainAppBar() }
    ) {
        MainContent(itemList) {
            // わからない
            navController.navigate("detail/${it.id}")
        }
    }
}


@Composable
fun MainContent(item: State<List<Item>>, itemSelected: (item: Item) -> Unit) {

    val title = Math.random().toString()


    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (constraintButtonRef,constraintAddButton) = createRefs()
        LazyColumn() {
            items(item.value) { item ->
                CardContent(item = item, itemSelected = itemSelected)

            }

        }
        Column(
            modifier = Modifier
                .constrainAs(constraintButtonRef) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
                .wrapContentSize()
        ) {

            Text(text = "MainScreen")
        }


    }


}

@Composable
fun CardContent(item: Item, itemSelected: (item: Item) -> Unit) {
    val textFontSize = 24.sp
    val fontWeight = FontWeight.Bold
    
    var checked = remember { mutableStateOf(false)}

    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(16.dp)
            .clickable { itemSelected(item) }
            .fillMaxWidth()) {
        Row( verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = item.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = textFontSize,
                fontWeight = fontWeight,
                modifier = Modifier.weight(weight = 1f, fill = true)
            )
            IconToggleButton(
                checked = checked.value,
                onCheckedChange = { checked.value = it },
            ) {
                val tint = animateColorAsState(targetValue = if (checked.value) Color(0xFFEC407A) else Color(0xFFB0BEC5))
                Icon(Icons.Filled.Favorite, contentDescription = "お気に入り", tint = tint.value)
            }
        }
        
    }
}

@Composable
fun MainAppBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
                },
    )
}

@Preview(showBackground = true)
@Composable
fun cardTestComposable() {
    val textFontSize = 24.sp
    val fontWeight = FontWeight.Bold

    var checked = remember { mutableStateOf(false)}

    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(16.dp)
//            .clickable { itemSelected(item) }
            .fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "item.tiaaaaa",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = textFontSize,
                fontWeight = fontWeight,
                modifier = Modifier.weight(weight = 1f, fill = true)
            )
            IconToggleButton(
                checked = checked.value,
                onCheckedChange = { checked.value = it },
//                modifier = Modifier.padding(8.dp)
            ) {
                val tint = animateColorAsState(targetValue = if (checked.value) Color(0xFFEC407A) else Color(0xFFB0BEC5))
                Icon(Icons.Filled.Favorite, contentDescription = "お気に入り", tint = tint.value)
            }
        }

    }
}


