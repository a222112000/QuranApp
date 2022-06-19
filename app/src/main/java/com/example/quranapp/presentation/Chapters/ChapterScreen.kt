package com.example.quranapp.presentation.Chapters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quranapp.presentation.Chapters.components.ChapterListItems
import com.example.quranapp.presentation.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChapterScreen(
    navController: NavController,
    viewModel: ChapterListViewModel = hiltViewModel(),
){
    val state = viewModel.state.value
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Surface(
            elevation = 2.dp,
            color = MaterialTheme.colors.primarySurface
        ) {
            Column(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn {
                    stickyHeader {
                        Column(modifier = Modifier
                            .fillMaxWidth()) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Quran Chapters",
                                    color = Color.White
                                )
                            }
                        }
                        Row(
                            modifier = androidx.compose.ui.Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Verses (translated) Arabic",
                                style = MaterialTheme.typography.body2,
                                color = Color.White,
                                overflow = TextOverflow.Ellipsis
                            )
                            Box(
                                modifier = Modifier.width(182.dp),
                                Alignment.TopEnd
                            ) {
                                Text(
                                    text = "Verses Count",
                                    style = MaterialTheme.typography.body2,
                                    color = Color.White,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.chapter) {
                    ChapterListItems(chapter = it ,onChapterClick = {
                        navController.navigate(Screen.ChapterDetailScreen.route+"/"+it.id+"/"+it.bismillahPre
                        +"/"+it.nameArabic+"/"+it.nameComplex+"/"+it.versesCount+"/"+it.translatedName.name+"/"+it.revelationPlace)
                    })
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

