package com.example.appmeteo.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class MeteoUiState(
    val ville: MutableState<String> = mutableStateOf(""),
    val temperature: MutableState<Double> = mutableStateOf(0.0),
    val description: MutableState<String> = mutableStateOf(""),
    val iconUrl: MutableState<String> = mutableStateOf("")
)
