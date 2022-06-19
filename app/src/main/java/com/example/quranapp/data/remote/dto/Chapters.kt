package com.example.quranapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Chapters(

    val bismillahPre: Boolean,
    val id: Int,
    val nameArabic: String,
    val nameComplex: String,
    val nameSimple: String,
    val revelationOrder: Int,
    val revelationPlace: String,
    val translatedName: TranslatedName,
    val versesCount: Int
)
