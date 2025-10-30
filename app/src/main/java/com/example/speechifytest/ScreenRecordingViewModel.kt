package com.example.speechifytest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.inc

class ScreenRecordingViewModel : ViewModel() {
    val _recordingScreenUIState: MutableStateFlow<RecordingScreenUIState> =
        MutableStateFlow(RecordingScreenUIState.Idle)
    var recordingScreenUIState = _recordingScreenUIState.asStateFlow()

    private var timerJob: Job? = null

    fun startRecording() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            var seconds = 0
            while (true) {
                _recordingScreenUIState.value = RecordingScreenUIState.Recording(seconds)
                delay(1000L);
                seconds++
            }


        }
    }

    fun stopRecording() {
        timerJob?.cancel()
        _recordingScreenUIState.value = RecordingScreenUIState.Idle
    }


    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }


}
