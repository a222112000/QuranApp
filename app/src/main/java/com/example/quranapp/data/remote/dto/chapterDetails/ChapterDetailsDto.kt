package com.example.quranapp.data.remote.dto.chapterDetails


import com.google.gson.annotations.SerializedName

data class ChapterDetailsDto(
    @SerializedName("bismillah_pre")
    val bismillahPre: Boolean,
    @SerializedName("chapter_number")
    val chapterNumber: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name_complex")
    val nameComplex: String,
    @SerializedName("name_simple")
    val nameSimple: String,
    @SerializedName("pages")
    val pages: List<Int>,
    @SerializedName("revelation_order")
    val revelationOrder: Int,
    @SerializedName("revelation_place")
    val revelationPlace: String,
    @SerializedName("translated_name")
    val translatedName: TranslatedName,
    @SerializedName("verses_count")
    val versesCount: Int
)