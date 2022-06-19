package com.example.quranapp.data.repository

import com.example.quranapp.data.remote.QuranApi
import com.example.quranapp.data.remote.dto.ChapterDto
import com.example.quranapp.data.remote.dto.QChapters
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetailsDto
import com.example.quranapp.domain.repository.ChapterRepo
import javax.inject.Inject

class ChapterRepoImpl @Inject constructor(
    private val api: QuranApi
): ChapterRepo{
    override suspend fun getChapter(): List<ChapterDto> {
        return api.getAll().chapters
    }

    override suspend fun getChapterById(id: String): ChapterDetailsDto {
       return api.getChapter(id)
    }

}