package com.demo.cleanarchitecturecoroutines.core.person.model

import com.demo.cleanarchitecturecoroutines.core.book.model.Book
import com.demo.cleanarchitecturecoroutines.core.film.model.Film

data class Person(
    val dni: Long,
    val name: String,
    val book: Book,
    val film: Film
)

data class PersonInput(
    val dni: Long,
    val name: String,
    val isbn: String,
    val title: String
)













