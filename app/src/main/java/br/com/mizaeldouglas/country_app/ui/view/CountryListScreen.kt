package br.com.mizaeldouglas.country_app.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.mizaeldouglas.country_app.data.model.Country
import br.com.mizaeldouglas.country_app.ui.view.components.CountryCard
import br.com.mizaeldouglas.country_app.ui.view.components.SearchBar
import br.com.mizaeldouglas.country_app.ui.viewmodel.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryListScreen(
    onCountryClick: (Country) -> Unit,
    viewModel: CountryViewModel = hiltViewModel()
) {
    val countries by viewModel.countries
    val isLoading by viewModel.isLoading
    val error by viewModel.error
    val searchQuery by viewModel.searchQuery



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Country App") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.LightGray
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column {
                SearchBar(query = searchQuery, onQueryChange = {
                    viewModel.onSearchQueryChanged(it)
                })

                if (isLoading && searchQuery.isEmpty()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                } else if (error != null && searchQuery.isEmpty()) {
                    Text("Error: $error", modifier = Modifier.align(Alignment.CenterHorizontally))
                } else {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(countries) { country ->
                            CountryCard(country = country, onCountryClick = onCountryClick)
                        }
                    }
                }
            }
        }
    }
}