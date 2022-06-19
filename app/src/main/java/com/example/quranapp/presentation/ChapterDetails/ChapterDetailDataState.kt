package com.example.quranapp.presentation.ChapterDetails

import com.example.quranapp.data.remote.dto.Chapters
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetails
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetailsDto

data class ChapterDetailDataState(
    val isLoading: Boolean = false,
    val chapter: ChapterDetailsDto? = null,
    val error: String = ""
)
