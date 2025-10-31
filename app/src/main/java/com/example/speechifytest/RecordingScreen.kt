package com.example.speechifytest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RecordingScreen (
    viewModel: ScreenRecordingViewModel = hiltViewModel()
) {
    val uiState by viewModel.recordingScreenUIState.collectAsState()

    RecordingScreenContent(
        recordingScreenUIState = uiState,
        { viewModel.startRecording() },
        { viewModel.stopRecording() }
    )
}


@Preview
@Composable
fun FirstComposablePreview() {
    RecordingScreen()
}