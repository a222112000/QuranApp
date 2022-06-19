package com.example.quranapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TranslatedName(
    @SerializedName("language_name")
    val languageName: String,
    @SerializedName("name")
    val name: String
)