package com.example.bookmarkbuttonbyjetpackcompose.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.bookmarkbuttonbyjetpackcompose.R
import com.example.bookmarkbuttonbyjetpackcompose.model.database.Item

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    Scaffold(
        topBar = { MainAppBar() },
        content = { MainContent(navController, viewModel) }
    )
}


@Composable
fun MainContent(navController: NavController, viewModel: MainViewModel) {

    val title = Math.random().toString()
    val itemList = viewModel.itemList.collectAsState(initial = emptyList())

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (constraintButtonRef,constraintAddButton) = createRefs()
        LazyColumn() {
            items(itemList.value) { item ->
                CardContent(item = item)
            }
//            item {
//                CardContent(text = "aaa")
//                CardContent(text = "bbb")
//                CardContent(text = "ccc")
//
////                Text(text = "aaa")
////                Text(text = "bbb")
////                Text(text = "ccc")
//            }
        }
        Column(
            modifier = Modifier
                .constrainAs(constraintButtonRef) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
                .wrapContentSize()
        ) {
            Button(onClick = { navController.navigate("detail") }) {
                Text(text = "Detail")
            }
            Text(text = "MainScreen")
        }
        Button(
            onClick = { viewModel.addItem(title) },
            modifier = Modifier
                .constrainAs(constraintAddButton) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        ) {
            Text(text = "Add")
        }

    }


}

@Composable
fun CardContent(item: Item) {
    val textFontSize = 24.sp
    val fontWeight = FontWeight.Bold

    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()) {
        Text(
            text = item.title,
            fontSize = textFontSize,
            fontWeight = fontWeight,
            modifier = Modifier
                .padding(16.dp))
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
fun TestComposable() {
    Scaffold(
        topBar = { MainAppBar() },
        content = {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (constraintButtonRef, constraintAddButton) = createRefs()

                LazyColumn() {
                    item {
//                        CardContent(text = "aaa")
//                        CardContent(text = "bbb")
//                        CardContent(text = "ccc")
                    }
                }
                Column(
                    modifier = Modifier
                        .constrainAs(constraintButtonRef) {
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
//                .wrapContentHeight()
                        .wrapContentSize()
                ) {

                    Button(onClick = {  }) {
                        Text(text = "Detail")
                    }
                    Text(text = "MainScreen")
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .constrainAs(constraintAddButton) {
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                ) {
                    Text(text = "Add")
                }
            }
        }
    )

}

