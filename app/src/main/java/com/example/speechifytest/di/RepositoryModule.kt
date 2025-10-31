package com.example.speechifytest.di

import com.example.speechifytest.data.IRecordingRepository
import com.example.speechifytest.data.RecordingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRecordingRepository(recordingRepositoryImpl: RecordingRepositoryImpl): IRecordingRepository

}