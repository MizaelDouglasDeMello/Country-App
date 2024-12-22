package br.com.mizaeldouglas.country_app


import CountryDetailsScreen
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.mizaeldouglas.country_app.data.model.Country
import br.com.mizaeldouglas.country_app.ui.theme.CountryAppTheme
import br.com.mizaeldouglas.country_app.ui.view.CountryListScreen
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountryApp()
                }
            }
        }
    }
}

@Composable
fun CountryApp() {
    val navController = rememberNavController()
    CountryNavHost(navController = navController)
}

@Composable
fun CountryNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "countryList") {
        composable("countryList") {
            CountryListScreen(onCountryClick = { country ->
                val countryJson = Uri.encode(Gson().toJson(country))
                navController.navigate("countryDetails/$countryJson")
            })
        }

        composable(
            route = "countryDetails/{country}",
            arguments = listOf(navArgument("country") { type = NavType.StringType })
        ) { backStackEntry ->
            val countryJson = backStackEntry.arguments?.getString("country")
            val country = Gson().fromJson(countryJson, Country::class.java)
            CountryDetailsScreen(country = country, navController = navController)
        }



    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryAppTheme {
        CountryApp()
    }
}