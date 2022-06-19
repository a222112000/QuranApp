package com.example.quranapp.presentation.ChapterDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.common.Constants
import com.example.quranapp.common.DataState
import com.example.quranapp.domain.usecase.getChapter.GetChapterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ChapterDetailViewModel @Inject constructor(
    private val getChapterUseCase: GetChapterUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    //look to this State dependency
    private val _state = mutableStateOf(ChapterDetailDataState())
    val state: State<ChapterDetailDataState> = _state

    init {
        savedStateHandle.get<String>(Constants.CHAPTER_ID)?.let {
            getChapter(it)
        }
    }

     fun getChapter(id: String){
        getChapterUseCase(id).onEach {
            when(it){
                is DataState.Success -> {
                    _state.value = ChapterDetailDataState(chapter = it.data)
                }
                is DataState.Error -> {
                    _state.value = ChapterDetailDataState(error = it.message ?: "Unknown Error")
                }
                is DataState.Loading -> {
                    _state.value = ChapterDetailDataState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}