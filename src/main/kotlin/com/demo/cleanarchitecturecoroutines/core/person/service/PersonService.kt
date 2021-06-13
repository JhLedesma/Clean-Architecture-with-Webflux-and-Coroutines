package com.demo.cleanarchitecturecoroutines.core.person.service

import com.demo.cleanarchitecturecoroutines.core.person.model.Person
import com.demo.cleanarchitecturecoroutines.core.person.model.PersonInput
import kotlinx.coroutines.flow.Flow

class PersonService {

    suspend fun createPerson(personInput: PersonInput): Person {

    }

    suspend fun getPerson(dni: Long): Person? {

    }

    suspend fun getPeople(): Flow<Person> {

    }
}