package com.demo.cleanarchitecturecoroutines.client

import com.demo.cleanarchitecturecoroutines.core.book.model.BookResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodyOrNull

class BookClient(private val host:String, private val webClient: WebClient) {

    suspend fun getBookResponse(isbn: String): BookResponse =
        webClient
            .get()
            .uri("$host/books/v1/volumes?q=isbn:$isbn")
            .retrieve()
            .awaitBodyOrNull()
            ?: throw RuntimeException("Not exist data for isbn: $isbn")
}

