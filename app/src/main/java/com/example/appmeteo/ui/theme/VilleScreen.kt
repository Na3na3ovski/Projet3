import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VilleScreen(villeViewModel: VilleViewModel = viewModel(), modifier: Modifier = Modifier) {
    var entree: String = ""
    val villeUiState = villeViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // City search section
        TextField(
            value = entree,
            onValueChange = { entree = it },
            label = { Text("Nom de la ville: ") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { villeViewModel.afficher() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Rechercher")
        }

        // Weather information section
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nom de la ville: ${villeUiState.value.nom}", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Température: ${villeUiState.value.meteo.temperature} °C")
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Description: ${villeUiState.value.meteo.description}")
    }
}

