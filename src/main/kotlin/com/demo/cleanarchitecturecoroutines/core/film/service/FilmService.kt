package com.demo.cleanarchitecturecoroutines.core.film.service

import com.demo.cleanarchitecturecoroutines.client.FilmClient
import com.demo.cleanarchitecturecoroutines.core.film.model.Film

class FilmService(private val filmClient: FilmClient) {

    suspend fun getFilm(title: String): Film =
        filmClient.getFilmResponse(title)
            .results
            .firstOrNull()
            ?.let { Film(title, it.seriesStartYear, it.seriesEndYear, it.numberOfEpisodes, it.runningTimeInMinutes) }
            ?: throw RuntimeException("Not exist results for title: $title")
}