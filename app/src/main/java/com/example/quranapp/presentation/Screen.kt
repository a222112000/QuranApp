package com.example.quranapp.presentation

import com.example.quranapp.data.remote.dto.ChapterDto
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetailsDto

sealed class Screen(val route: String){
    object ChapterListScreen: Screen("Chapters")
    object ChapterDetailScreen: Screen("ChapterDetails")

    fun withId(vararg args: Boolean): String{
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}