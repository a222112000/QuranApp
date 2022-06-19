package com.example.quranapp.domain.usecase.getChapter

import com.example.quranapp.common.DataState
import com.example.quranapp.data.remote.dto.Chapters
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetails
import com.example.quranapp.data.remote.dto.chapterDetails.ChapterDetailsDto
import com.example.quranapp.data.remote.dto.chapterDetails.toChapterDetails
import com.example.quranapp.data.remote.dto.toChapter
import com.example.quranapp.domain.repository.ChapterRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetChapterUseCase @Inject constructor(
    private val repository: ChapterRepo
){
    operator fun invoke(id: String): Flow<DataState<ChapterDetailsDto>> = flow{
        try {
            emit(DataState.Loading())
            val chapter = repository.getChapterById(id)
            emit(DataState.Success<ChapterDetailsDto>(chapter))
        } catch (e: Throwable){
            emit(DataState.Error<ChapterDetailsDto>(e.message.toString()))
        } catch (e: IOException) {
            emit(DataState.Error<ChapterDetailsDto>("No Internet Connection"))
        }
    }
}