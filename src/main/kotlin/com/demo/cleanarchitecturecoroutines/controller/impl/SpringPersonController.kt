package com.demo.cleanarchitecturecoroutines.controller.impl

import com.demo.cleanarchitecturecoroutines.controller.PersonController
import com.demo.cleanarchitecturecoroutines.core.person.model.Person
import com.demo.cleanarchitecturecoroutines.core.person.model.PersonInput
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.delayEach
import kotlinx.coroutines.flow.onEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class SpringPersonController(@Autowired private val personController: PersonController) {

    @PostMapping("/people")
    suspend fun createPerson(@RequestBody personInput: PersonInput) =
        personController.createPerson(personInput)

    @GetMapping("/people/{dni}")
    suspend fun getPerson(@PathVariable dni: Long): Person =
        personController.getPerson(dni)

    @GetMapping("/people")
    suspend fun getPeople(): Flow<Person> =
        personController.getPeople()

    @GetMapping("/people-stream", produces = [MediaType.APPLICATION_NDJSON_VALUE])
    suspend fun getPeopleStream(): Flow<Person> =
        personController.getPeople().onEach { delay(5000) }
}

