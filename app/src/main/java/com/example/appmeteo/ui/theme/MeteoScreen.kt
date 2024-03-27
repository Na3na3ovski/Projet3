package com.example.appmeteo.ui.theme

import com.example.weatherapp.ui.MeteoViewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun MeteoScreen(meteoViewModel: MeteoViewModel = viewModel()) {
    val meteoUiState = meteoViewModel.uiState.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = meteoUiState.ville.value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Météo: ${meteoUiState.description.value}",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Température: ${meteoUiState.temperature.value} °C",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        val currentDate = LocalDate.now()
        val dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
        Text(
            text = "Date d'aujourd'hui: ${currentDate.format(dateFormatter)}",
            fontSize = 16.sp
        )
    }
}

