package com.demo.cleanarchitecturecoroutines.app.web

import com.demo.cleanarchitecturecoroutines.controller.PersonController
import com.demo.cleanarchitecturecoroutines.core.person.model.Person
import com.demo.cleanarchitecturecoroutines.core.person.model.PersonInput
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
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
}