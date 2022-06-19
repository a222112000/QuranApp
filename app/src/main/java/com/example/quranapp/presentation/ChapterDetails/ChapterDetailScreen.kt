package com.example.quranapp.presentation.ChapterDetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quranapp.data.remote.dto.ChapterDto
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetailsDto
import com.example.quranapp.presentation.Chapters.ChapterListViewModel
import com.example.quranapp.presentation.Chapters.components.ChapterListItems
import com.example.quranapp.presentation.Screen

@Composable
fun ChapterDetailScreen(
    navController: NavController,
    id: String,
    bismillahPre: String,
    name_arabic: String,
    name_complex: String,
    verses_count: Int,
    translated_name: String,
    revelation_place: String
){

    Box(modifier = Modifier.fillMaxSize()){
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.primary)

                                .padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Text(
                                    color = Color.White,
                                    text = " The Chapter Details",
                                    style = MaterialTheme.typography.h4,
                                    modifier = Modifier.weight(4f)
                                )
                            }
                        }
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(5.dp)
                            ) {
                                Text(text = "In Arabic $name_arabic And Chapter Complex name $name_complex")

                            }
                            Row(modifier = Modifier.fillMaxWidth()
                                .padding(5.dp)) {
                                Text(text = "Verses Count $verses_count")
                            }
                            Row(modifier = Modifier.fillMaxWidth()
                                .padding(5.dp)) {
                                Text(text = "Chapter translated to English as ( $translated_name ) and the revelation place is ${revelation_place.toUpperCase()}")
                            }
                        }
                    }
                }
            }
    }
}