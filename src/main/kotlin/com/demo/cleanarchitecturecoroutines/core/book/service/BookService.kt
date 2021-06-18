package com.demo.cleanarchitecturecoroutines.core.book.service

import com.demo.cleanarchitecturecoroutines.client.BookClient
import com.demo.cleanarchitecturecoroutines.core.book.model.Book

class BookService(private val bookClient: BookClient) {

    suspend fun getBook(isbn: String): Book =
        bookClient.getBookResponse(isbn)
            .items
            .firstOrNull()
            ?.volumeInfo
            ?.let { Book(isbn, it.title, it.authors.first(), it.publisher, it.publishedDate, it.categories.first()) }
            ?: throw RuntimeException("Not exist Items for isbn: $isbn")
}



