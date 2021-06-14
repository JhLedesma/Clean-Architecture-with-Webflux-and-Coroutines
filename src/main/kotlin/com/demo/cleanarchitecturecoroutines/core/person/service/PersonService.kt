package com.demo.cleanarchitecturecoroutines.core.person.service

import com.demo.cleanarchitecturecoroutines.core.book.service.BookService
import com.demo.cleanarchitecturecoroutines.core.film.service.FilmService
import com.demo.cleanarchitecturecoroutines.core.person.model.Person
import com.demo.cleanarchitecturecoroutines.core.person.model.PersonInput
import com.demo.cleanarchitecturecoroutines.repository.PersonRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow

class PersonService(private val bookService: BookService, private val filmService: FilmService, private val personRepository: PersonRepository){

    suspend fun createPerson(personInput: PersonInput): Person = coroutineScope {
        val bookAsync = async { bookService.getBook(personInput.isbn) }
        val filmAsync = async { filmService.getFilm(personInput.title) }

        personRepository.save(Person(personInput.dni, personInput.name, bookAsync.await(), filmAsync.await()))
    }

    suspend fun getPerson(dni: Long): Person =
        personRepository.findByDni(dni)
            ?: throw RuntimeException("Not found person for dni: $dni")

    suspend fun getPeople(): Flow<Person> =
        personRepository.findAll()
}