package com.demo.cleanarchitecturecoroutines.app.config

import com.demo.cleanarchitecturecoroutines.client.BookClient
import com.demo.cleanarchitecturecoroutines.client.FilmClient
import com.demo.cleanarchitecturecoroutines.controller.PersonController
import com.demo.cleanarchitecturecoroutines.core.book.service.BookService
import com.demo.cleanarchitecturecoroutines.core.film.service.FilmService
import com.demo.cleanarchitecturecoroutines.core.person.service.PersonService
import com.demo.cleanarchitecturecoroutines.repository.adapter.PersonAdapterRepository
import com.demo.cleanarchitecturecoroutines.repository.dao.PersonDao
import com.demo.cleanarchitecturecoroutines.utils.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class SpringDependenciesConfig(@Autowired private val personDao: PersonDao) {

    @Value("\${book.host}")
    private lateinit var bookHost: String
    @Value("\${film.host}")
    private lateinit var filmHost: String
    @Value("\${film.host_key}")
    private lateinit var filmHostKey: String
    @Value("\${film.api_key}")
    private lateinit var filmApiKey: String

    @Bean
    fun webClient(): WebClient = WebClient
            .builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build()
    @Bean
    fun modelMapper() = ModelMapper()
    @Bean
    fun personRepository() = PersonAdapterRepository(personDao, modelMapper())
    @Bean
    fun bookClient() = BookClient(bookHost, webClient())
    @Bean
    fun filmClient() = FilmClient(filmHost, filmApiKey, filmHostKey, webClient())
    @Bean
    fun bookService() = BookService(bookClient())
    @Bean
    fun filmService() = FilmService(filmClient())
    @Bean
    fun personService() = PersonService(bookService(), filmService(), personRepository())
    @Bean
    fun personController() = PersonController(personService())
}