package com.example.quranapp.presentation.Chapters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.common.DataState
import com.example.quranapp.domain.usecase.getChapters.GetChaptersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ChapterListViewModel @Inject constructor(
    private val getChapterUseCase: GetChaptersUseCase
) : ViewModel(){
//look to this State dependency
    private val _state = mutableStateOf(ChapterDataState())
    val state: State<ChapterDataState> = _state

    init {
        getChapters()
    }

    private fun getChapters(){
        getChapterUseCase().onEach {
            when(it){
                is DataState.Success -> {
                    _state.value = ChapterDataState(chapter = it.data ?: emptyList())
                }
                is DataState.Error -> {
                    _state.value = ChapterDataState(error = it.message ?: "Unknown Error")
                }
                is DataState.Loading -> {
                    _state.value = ChapterDataState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
 }