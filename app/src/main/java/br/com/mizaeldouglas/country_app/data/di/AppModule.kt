package br.com.mizaeldouglas.country_app.data.di

import br.com.mizaeldouglas.country_app.data.api.CountryApi
import br.com.mizaeldouglas.country_app.data.api.CountryService
import br.com.mizaeldouglas.country_app.data.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://restcountries.com/v3.1/"


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryApi(retrofit: Retrofit): CountryApi {
        return retrofit.create(CountryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryService(countryApi: CountryApi): CountryService {
        return CountryService(countryApi)
    }

    @Provides
    @Singleton
    fun provideCountryRepository(countryService: CountryService): CountryRepository {
        return CountryRepository(countryService)
    }
}