package com.ilgul.horoscapp.data

import android.util.Log
import com.ilgul.horoscapp.data.network.HoroscopeApiService
import com.ilgul.horoscapp.domain.model.PredictionModel
import com.ilgul.horoscapp.domain.model.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Achtung!", "Error occurs ${it.message}") }

        return null
    }
}