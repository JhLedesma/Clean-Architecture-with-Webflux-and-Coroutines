package com.demo.cleanarchitecturecoroutines.client.impl

import com.demo.cleanarchitecturecoroutines.client.BookClient
import com.demo.cleanarchitecturecoroutines.core.book.model.BookResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodyOrNull

class BookClientImpl(private val host:String, private val webClient: WebClient) : BookClient {

    override suspend fun getBookResponse(isbn: String): BookResponse =
        webClient
            .get()
            .uri("$host/books/v1/volumes?q=isbn:$isbn")
            .retrieve()
            .awaitBodyOrNull()
            ?: throw RuntimeException("Not exist data for isbn: $isbn")
}

