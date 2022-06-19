package com.example.quranapp.data.remote.dto.chapterDetails


import com.google.gson.annotations.SerializedName

data class Chapter(
    @SerializedName("chapter")
    val chapter: ChapterDetailsDto
)