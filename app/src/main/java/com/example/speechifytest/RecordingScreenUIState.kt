package com.example.speechifytest

sealed class RecordingScreenUIState {
    object Idle: RecordingScreenUIState()
    class Recording(val seconds:Int): RecordingScreenUIState()
    class Error (val message:String) : RecordingScreenUIState()
}