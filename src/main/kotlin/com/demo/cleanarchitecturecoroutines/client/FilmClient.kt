package com.demo.cleanarchitecturecoroutines.client

import com.demo.cleanarchitecturecoroutines.core.film.model.FilmResponse

interface FilmClient {
    suspend fun getFilmResponse(title: String): FilmResponse
}

