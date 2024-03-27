// MeteoViewModel.kt
package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.appmeteo.ui.theme.MeteoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MeteoViewModel : ViewModel() {
    // L'état de l'interface utilisateur (UI State)
    private val _uiState = MutableStateFlow(MeteoUiState())
    val uiState: StateFlow<MeteoUiState> = _uiState.asStateFlow()

    private var _ville = mutableStateOf("")
    private var _temperature = mutableStateOf(0.0)
    private var _description = mutableStateOf("")

    // Fonction pour mettre à jour la ville
    fun updateVille(ville: String) {
        _ville.value = ville
    }

    // Fonction pour mettre à jour la température
    fun updateTemperature(temperature: Double) {
        _temperature.value = temperature
    }

    // Fonction pour mettre à jour la description
    fun updateDescription(description: String) {
        _description.value = description
    }

    fun getVille() : String{
        return _ville.value
    }
    fun getTemperature() : Double{
        return _temperature.value
    }
    fun getDescription() : String{
        return _description.value
    }

    fun resetVille(){
        _ville.value = "";
    }
    fun resetTemperature(){
        _temperature.value = 0.0;
    }
    fun resetDescription(){
        _description.value = "";
    }

}
