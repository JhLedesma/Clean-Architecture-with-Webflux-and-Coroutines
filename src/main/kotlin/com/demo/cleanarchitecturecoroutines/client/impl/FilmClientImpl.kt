package com.demo.cleanarchitecturecoroutines.client.impl

import com.demo.cleanarchitecturecoroutines.client.FilmClient
import com.demo.cleanarchitecturecoroutines.core.film.model.FilmResponse
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodyOrNull

class FilmClientImpl(
    private val host: String,
    private val apiKey: String,
    private val apiHost: String,
    private val webClient: WebClient
) : FilmClient {

    override suspend fun getFilmResponse(title: String): FilmResponse =
        webClient
            .get()
            .uri("$host/title/find?q=$title")
            .header("x-rapidapi-key", apiKey)
            .header("x-rapidapi-host", apiHost)
            .retrieve()
            .awaitBodyOrNull()
            ?: throw RuntimeException("Not exist data for title: $title")
}

