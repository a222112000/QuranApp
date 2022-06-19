package com.example.quranapp.data.remote

import com.example.quranapp.data.remote.dto.ChapterDto
import com.example.quranapp.data.remote.dto.QChapters
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetails
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuranApi {

    @GET("api/v3/chapters")
    suspend fun getAll(): QChapters

    @GET("api/v3/chapters/{id}")
    suspend fun getChapter(@Path("id")id: String):ChapterDetailsDto
}