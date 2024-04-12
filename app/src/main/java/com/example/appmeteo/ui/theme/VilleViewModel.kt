import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.appmeteo.modele.Meteo
import com.example.appmeteo.modele.Ville
import com.example.appmeteo.network.WeatherApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VilleViewModel : ViewModel() {

    // L'état de l'interface utilisateur (UI State)
    private val _uiState = MutableStateFlow(Ville("",   Meteo( 0.0, "")))

    val uiState: StateFlow<Ville> = _uiState.asStateFlow()

    private var _nomVille = MutableStateFlow("Montréal")

    fun updateNomVille(nom: String) {
        _nomVille.value = nom
    }

    fun getNomVille(): String {
        return _nomVille.value
    }

    // Action
    fun afficher() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: WeatherApiService = retrofit.create(WeatherApiService::class.java)
        val requete = service.getData(_nomVille.value, "f99e73348d6ed6f7e74dbf8bbe5c75bc")

        requete.enqueue(object : Callback<Ville> {
            override fun onResponse(call: Call<Ville>, response: Response<Ville>) {
                val data: Ville = response.body() as Ville

                    Log.d("allo", data.nom)
                    _uiState.update { currentState ->
                        currentState.copy(
                            nom = data.nom,
                            meteo = Meteo(
                                temperature = data.meteo.temperature,
                                description = data.meteo.description
                            )
                        )
                    }

            }
            override fun onFailure(call: Call<Ville>, t: Throwable) {
                Log.e("Error", t.stackTraceToString())
            }
        })
    }
}
