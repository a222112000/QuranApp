package com.example.quranapp.domain.repository

import com.example.quranapp.data.remote.dto.ChapterDto
import com.example.quranapp.data.remote.dto.QChapters
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetailsDto

interface ChapterRepo {
    suspend fun getChapter(): List<ChapterDto>
    suspend fun getChapterById(id: String): ChapterDetailsDto
}