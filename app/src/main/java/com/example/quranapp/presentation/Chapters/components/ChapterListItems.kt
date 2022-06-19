package com.example.quranapp.presentation.Chapters.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.quranapp.data.remote.dto.ChapterDto
import com.example.quranapp.data.remote.dto.Chapters
import com.example.quranapp.data.remote.dto.QChapters
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetails
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetailsDto

@Composable
fun ChapterListItems(
    chapter: ChapterDto,
    onChapterClick: (ChapterDto) -> Unit
){
    Row(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .clickable{ onChapterClick(chapter)}
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "${chapter.nameComplex}(${chapter.translatedName.name}) ${chapter.nameArabic}",
        style = MaterialTheme.typography.body1,
        overflow = TextOverflow.Ellipsis)
        Text(text = "${chapter.versesCount}",
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            overflow = TextOverflow.Ellipsis)

    }
}