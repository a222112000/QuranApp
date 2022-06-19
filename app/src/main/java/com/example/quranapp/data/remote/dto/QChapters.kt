package com.example.quranapp.data.remote.dto

import com.google.gson.annotations.SerializedName
data class QChapters(
    @SerializedName("chapters")
    val chapters: List<ChapterDto>
)

fun QChapters.toChapter(): QChapters{
    return QChapters(
        chapters = chapters
    )
}