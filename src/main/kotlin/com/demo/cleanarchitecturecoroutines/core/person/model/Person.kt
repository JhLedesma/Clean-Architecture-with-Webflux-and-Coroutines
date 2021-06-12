package com.demo.cleanarchitecturecoroutines.core.person.model

import com.demo.cleanarchitecturecoroutines.core.book.model.Book
import com.demo.cleanarchitecturecoroutines.core.film.model.Film

data class Person(
    val name: String,
    val book: Book,
    val film: Film,
    val id: String
)













