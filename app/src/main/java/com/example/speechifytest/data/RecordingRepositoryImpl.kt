package com.example.speechifytest.data

import android.Manifest
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecordingRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : IRecordingRepository {
    private var duration: Int = 0
    private var isRecording: Boolean = false

    override fun hasPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.RECORD_AUDIO
        ) == PermissionChecker.PERMISSION_GRANTED
    }

    override suspend fun startRecording(): Result<Unit> {
        return try {
            if (!hasPermission()) {
                return Result.failure(SecurityException("Microphone permission not granted"))
            }
            isRecording = true
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun stopRecording(): Result<Unit> {
        return try {
            isRecording = false
            duration = 0;
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getRecording(): Flow<Int> = flow {
        var seconds = 0
        if (isRecording) {
            emit(seconds)
            delay(1000L)
            seconds++
        }
        emit(0)
    }
}