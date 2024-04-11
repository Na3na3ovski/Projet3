import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmeteo.ui.theme.MeteoUiState
import com.example.appmeteo.Network.WeatherApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MeteoViewModel : ViewModel() {

    // L'état de l'interface utilisateur (UI State)
    private val _uiState = MutableStateFlow(Meteo("", 0.0, "", ""))
    val uiState: StateFlow<Meteo> = _uiState.asStateFlow()

    private var _nomMeteo = MutableStateFlow("")

    fun updateNomMeteo(nom:String) {
        _nomMeteo.value = nom
    }
    fun getNomMeteo(): String {
        return _nomMeteo.value
    }

    //action
    fun afficher(){
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/weather")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service :
    }
}
