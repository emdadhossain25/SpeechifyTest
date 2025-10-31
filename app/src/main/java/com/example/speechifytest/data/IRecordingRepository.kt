package com.example.speechifytest.data

import kotlinx.coroutines.flow.Flow

interface IRecordingRepository {

    fun hasPermission():Boolean


    suspend fun startRecording():Result<Unit>

    suspend fun stopRecording(): Result<Unit>

    fun getRecording(): Flow<Int>
}