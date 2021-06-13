package com.demo.cleanarchitecturecoroutines.controller

import com.demo.cleanarchitecturecoroutines.core.person.service.PersonService
import com.demo.cleanarchitecturecoroutines.core.person.model.Person
import com.demo.cleanarchitecturecoroutines.core.person.model.PersonInput

class PersonController(private val personService: PersonService) {

    suspend fun createPerson(personInput: PersonInput): Person =
        personService.createPerson(personInput)
}

