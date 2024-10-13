package com.example.mealsapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import coil.compose.AsyncImage
import com.example.mealsapp.presentation.viewModel.GetMealsViewModel

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        Home()


    }
}

@Composable
fun Home() {
    val viewModel = GetMealsViewModel()
    viewModel.category()
    val categories = viewModel.categoryResponse.collectAsState()
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(categories.value?.categories ?: emptyList()) {
                Card(
                    modifier = androidx.compose.ui.Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Row {

                        AsyncImage(
                            model = it?.strCategoryThumb,
                            contentDescription = null,
                            modifier = androidx.compose.ui.Modifier.padding(16.dp),
                            contentScale = ContentScale.FillHeight

                        )
                        Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
                            Text(text = "${it?.strCategory}", fontWeight = FontWeight.Bold)
                            Text(text = "${it?.strCategoryDescription}", maxLines = 2)
                        }

                    }
                }

            }
        }


    }

}