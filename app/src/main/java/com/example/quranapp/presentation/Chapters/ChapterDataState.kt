package com.example.quranapp.presentation.Chapters

import com.example.quranapp.data.remote.dto.ChapterDto
import com.example.quranapp.data.remote.dto.Chapters
import com.example.quranapp.data.remote.dto.QChapters

data class ChapterDataState(
    val isLoading: Boolean = false,
    val chapter: List<ChapterDto> = emptyList(),
    val error: String = ""
)
