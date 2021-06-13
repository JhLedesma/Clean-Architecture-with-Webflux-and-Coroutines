package com.demo.cleanarchitecturecoroutines.core.film.model

data class Film(
    val title: String,
    val seriesStartYear: String,
    val seriesEndYear: String,
    val numberOfEpisodes: String,
    val runningTimeInMinutes: String
)

data class FilmResponse(
    val query: String,
    val results: List<Result>
)

data class Result(
    val id: String,
    val numberOfEpisodes: Int,
    val runningTimeInMinutes: Int,
    val seriesEndYear: Int,
    val seriesStartYear: Int,
    val title: String,
    val titleType: String
)


