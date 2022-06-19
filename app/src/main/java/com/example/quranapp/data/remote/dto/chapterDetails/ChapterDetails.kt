package com.example.quranapp.data.remote.dto.chapterDetails

import com.google.gson.annotations.SerializedName

data class ChapterDetails(
    val bismillahPre: Boolean,
    val chapterNumber: Int,
    val id: Int,
    val nameComplex: String,
    val nameSimple: String,
    val pages: List<Int>,
    val revelationOrder: Int,
    val revelationPlace: String,
    val translatedName: TranslatedName,
    val versesCount: Int
)

fun ChapterDetailsDto.toChapterDetails(): ChapterDetails{
    return ChapterDetails(
        id = id,
        bismillahPre = bismillahPre,
        chapterNumber = chapterNumber,
        nameComplex = nameComplex,
        nameSimple = nameSimple,
        pages = pages,
        revelationOrder = revelationOrder,
        revelationPlace = revelationPlace,
        translatedName = translatedName,
        versesCount = versesCount
    )
}