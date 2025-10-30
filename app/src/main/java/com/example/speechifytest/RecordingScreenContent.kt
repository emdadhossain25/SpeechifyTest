package com.example.speechifytest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecordingScreenContent(
    recordingScreenUIState: RecordingScreenUIState,
    startRecording: () -> Unit,
    stopRecording: () -> Unit

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                text = "Speech Recorder",
                textAlign = TextAlign.Start,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily.Monospace


            )
            when (recordingScreenUIState) {
                is RecordingScreenUIState.Error -> {
                    ErrorState(message = recordingScreenUIState.message)
                }

                RecordingScreenUIState.Idle -> {
                    IdleState(onStartRecording = startRecording)
                }

                is RecordingScreenUIState.Recording -> {
                    RecordingState(
                        seconds = recordingScreenUIState.seconds,
                        onStopeRecording = stopRecording

                    )
                }
            }
        }
    }
}

@Composable
fun IdleState(onStartRecording: () -> Unit) {
    IconButton(
        onClick = onStartRecording
    ) {
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "start recording",
            tint = Color.White,
            modifier = Modifier.size(156.dp)
        )
    }

    Text(
        text = "00:00",
        fontSize = 56.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
    )

    Text(
        text = "tap to start",
        fontSize = 16.sp,
        color = Color.White.copy(alpha = 0.7f),
    )

}

@Composable
fun RecordingState(seconds: Int, onStopeRecording: () -> Unit) {
    IconButton(
        onClick = onStopeRecording,
        modifier = Modifier.size(120.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Stop Recording",
            tint = Color.White,
            modifier = Modifier.size(100.dp)
        )
    }
    Text(
        text = formatTime(seconds),
        fontSize = 56.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
    )

    Text(
        text = "Recording",
        fontSize = 20.sp,
        color = Color.White
    )
}

@Composable
fun ErrorState(message: String) {
    Text(
        text = "Error : $message",
        fontSize = 16.sp,
        color = Color.White.copy(alpha = 0.7f)
    )

}

fun formatTime(totalSeconds: Int): String {
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return "%02d:%02d".format(minutes, seconds)
}


@Preview
@Composable
private fun RecordingStatePreview() {
    RecordingScreenContent(
        recordingScreenUIState = RecordingScreenUIState.Recording(seconds = 12334),
        startRecording = {},
        stopRecording = {}
    )
}

@Preview
@Composable
private fun IdleStatePreview() {
    RecordingScreenContent(
        recordingScreenUIState = RecordingScreenUIState.Idle,
        startRecording = {},
        stopRecording = {}
    )
}


@Preview
@Composable
private fun ErrorStatePreview() {
    RecordingScreenContent(
        recordingScreenUIState = RecordingScreenUIState.Error(message = "preview for error"),
        startRecording = {},
        stopRecording = {}
    )
}