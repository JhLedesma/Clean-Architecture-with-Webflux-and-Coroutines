package com.demo.cleanarchitecturecoroutines.repository.entity

import com.demo.cleanarchitecturecoroutines.core.book.model.Book
import com.demo.cleanarchitecturecoroutines.core.film.model.Film
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PersonDocument(
    @Id
    val dni: Long,
    val name: String,
    val book: Book,
    val film: Film
)


