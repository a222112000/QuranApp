package com.example.quranapp.presentation.ChapterDetails.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun ChapterTag(
    tag: String
) {
    Card(border = BorderStroke(2.dp, Color.Blue), backgroundColor = Color.Gray) {
        Text(
            text = tag, color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center, style = MaterialTheme.typography.body2)
    }
}