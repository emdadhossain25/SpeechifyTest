package com.example.speechifytest

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RecordingScreen(
    viewModel: ScreenRecordingViewModel = hiltViewModel()
) {
    val uiState by viewModel.recordingScreenUIState.collectAsState()

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.startRecording()
        } else {
            viewModel.showPermissionDeniedError()
        }
    }
    RecordingScreenContent(
        recordingScreenUIState = uiState,
        {
//            viewModel.startRecording()
            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
        },
        { viewModel.stopRecording() },
        onDismissError = {
            viewModel.dismissError()
        }
    )
}


@Preview
@Composable
fun FirstComposablePreview() {
    RecordingScreen()
}