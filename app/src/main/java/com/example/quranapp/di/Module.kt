package com.example.quranapp.di

import com.example.quranapp.common.Constants
import com.example.quranapp.data.remote.QuranApi
import com.example.quranapp.data.repository.ChapterRepoImpl
import com.example.quranapp.domain.repository.ChapterRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun providesApi(): QuranApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuranApi::class.java)
    }

    @Provides
    @Singleton
    fun provideChapterRepository(api: QuranApi): ChapterRepo{
        return ChapterRepoImpl(api)
    }
}