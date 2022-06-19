package com.example.quranapp.domain.usecase.getChapters

import com.example.quranapp.common.DataState
import com.example.quranapp.data.remote.dto.ChapterDto
import com.example.quranapp.data.remote.dto.Chapters
import com.example.quranapp.data.remote.dto.QChapters
import com.example.quranapp.data.remote.dto.toChapter
import com.example.quranapp.domain.repository.ChapterRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetChaptersUseCase @Inject constructor(
    private val repository: ChapterRepo
){
    operator fun invoke(): Flow<DataState<List<ChapterDto>>> = flow{
        try {
           emit(DataState.Loading())
           val chapters = repository.getChapter().map { it }
           emit(DataState.Success<List<ChapterDto>>(chapters))
        } catch (e: Throwable){
            emit(DataState.Error<List<ChapterDto>>(e.message.toString()))
        } catch (e: IOException) {
            emit(DataState.Error<List<ChapterDto>>("No Internet Connection"))
        }
    }
}