package br.com.mizaeldouglas.country_app.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.mizaeldouglas.country_app.data.model.Country
import br.com.mizaeldouglas.country_app.data.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(private val repository: CountryRepository) : ViewModel() {

    private val _countries = mutableStateOf<List<Country>>(emptyList())
    val countries: State<List<Country>> = _countries

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    init {
        loadCountries()
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        if (query.isBlank()) {
            loadCountries()
        } else {
            searchCountriesByName(query)
        }
    }

    private fun loadCountries() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            val response = repository.getAllCountries()
            handleResponse(response)
        }
    }

    private fun searchCountriesByName(name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            val response = repository.getCountriesByName(name)
            handleResponse(response)
        }
    }

    private fun handleResponse(response: Response<List<Country>>) {
        _isLoading.value = false
        if (response.isSuccessful) {
            _countries.value = response.body() ?: emptyList()
        } else {
            _error.value = "Error: ${response.code()}"
        }
    }
}