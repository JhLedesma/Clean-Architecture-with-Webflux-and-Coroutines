package com.demo.cleanarchitecturecoroutines.client

import com.demo.cleanarchitecturecoroutines.core.book.model.BookResponse

interface BookClient {
    suspend fun getBookResponse(isbn: String): BookResponse
}

