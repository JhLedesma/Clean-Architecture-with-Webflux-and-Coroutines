package com.demo.cleanarchitecturecoroutines.client

import com.demo.cleanarchitecturecoroutines.core.book.model.BookResponse
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.web.reactive.function.client.WebClient

class BookClient(private val host:String, private val webClient: WebClient) {

    suspend fun getBookResponse(isbn: String): BookResponse =
        webClient
            .get()
            .uri("$host?q=isbn:$isbn")
            .retrieve()
            .bodyToMono(BookResponse::class.java)
            .awaitSingleOrNull()
            ?: throw RuntimeException("Not exist data for isbn: $isbn")
}