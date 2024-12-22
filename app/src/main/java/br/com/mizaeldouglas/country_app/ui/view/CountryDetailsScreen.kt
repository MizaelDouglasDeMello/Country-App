package br.com.mizaeldouglas.country_app.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.mizaeldouglas.country_app.data.model.Country
import coil.compose.AsyncImage

@Composable
fun CountryDetailsScreen(country: Country) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                AsyncImage(
                    model = country.flags.png,
                    contentDescription = "Flag of ${country.name.common}",
                    modifier = Modifier.fillMaxWidth()
                )
                if (country.coatOfArms?.png != null) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Coat of Arms",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    AsyncImage(
                        model = country.coatOfArms.png,
                        contentDescription = "Coat of Arms of ${country.name.common}",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = country.name.common,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Official Name: ${country.name.official}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "Capital: ${country.capital?.joinToString(", ") ?: "N/A"}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text("Region: ${country.region}", style = MaterialTheme.typography.bodyLarge)
                if (!country.subregion.isNullOrEmpty()) {
                    Text(
                        "Subregion: ${country.subregion}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Text(
                    "Population: ${country.population}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text("Area: ${country.area} km²", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}