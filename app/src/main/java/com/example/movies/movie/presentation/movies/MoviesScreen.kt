package com.example.movies.movie.presentation.movies
import android.widget.LinearLayout
import com.example.movies.movie.presentation.movies.components.CardMovie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.compose.rememberImagePainter
import com.example.movies.movie.presentation.ui.Screen


@OptIn(ExperimentalFoundationApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    navController: NavController
){
    val state = viewModel.state.value
    val state1 = viewModel.state1.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "MOVIES") },
                elevation = 0.dp
            )
        }
    ) {

        Row() {
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),

                // content padding
                contentPadding = PaddingValues(
                    start = 12.dp,
                    top = 16.dp,
                    end = 12.dp,
                    bottom = 16.dp
                ),
                content = {
                    items(state1.characters) { character ->
                        Card(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth(),
                            elevation = 8.dp
                        ) {
                            Box(modifier = Modifier.height(200.dp)){
                                Image(
                                    painter = rememberImagePainter(character.image),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                                Box(modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                Color.Transparent,
                                                Color.Black
                                            ),
                                            startY = 300f
                                        )
                                    ))
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(12.dp),
                                    contentAlignment = Alignment.BottomCenter
                                ){
                                    Text(
                                        text = character.name.toString(),
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Start,
                                        fontSize = 16.sp,
                                        color = Color(0xFFFFFFFF),
                                    )
                                }

                            }
                        }
                    }
                }
            )
        }
    }

}
