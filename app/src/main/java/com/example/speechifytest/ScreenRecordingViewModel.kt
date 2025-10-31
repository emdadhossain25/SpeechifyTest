package com.example.speechifytest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.speechifytest.data.IRecordingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ScreenRecordingViewModel @Inject constructor(
    val repository: IRecordingRepository
) : ViewModel() {
    val _recordingScreenUIState: MutableStateFlow<RecordingScreenUIState> =
        MutableStateFlow(RecordingScreenUIState.Idle)
    var recordingScreenUIState = _recordingScreenUIState.asStateFlow()

    private var durationJob: Job? = null

    fun startRecording() {
        viewModelScope.launch {
            val result = repository.startRecording()

            result.onSuccess {
                durationJob?.cancel()
                durationJob = viewModelScope.launch {
                    repository.getRecording().collect { seconds ->
                        _recordingScreenUIState.value = RecordingScreenUIState.Recording(seconds)
                    }

                }
            }.onFailure { error ->
                _recordingScreenUIState.value = RecordingScreenUIState.Error(
                    message = error.message ?: "Failed to start recording"
                )
            }
        }

    }

    fun stopRecording() {
        viewModelScope.launch {
            durationJob?.cancel()
            repository.stopRecording()
            _recordingScreenUIState.value = RecordingScreenUIState.Idle
        }
    }


    override fun onCleared() {
        super.onCleared()
        durationJob?.cancel()
    }

    fun showPermissionDeniedError() {
        _recordingScreenUIState.value =
            RecordingScreenUIState.Error("Microphone permission is required to record audio. " + "Please grant permission in Settings.")
    }

    fun dismissError() {
        if (_recordingScreenUIState.value is RecordingScreenUIState.Error) {
            _recordingScreenUIState.value = RecordingScreenUIState.Idle
        }
    }


}
