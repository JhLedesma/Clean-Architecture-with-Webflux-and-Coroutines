package com.demo.cleanarchitecturecoroutines.repository

import com.demo.cleanarchitecturecoroutines.core.person.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {

    suspend fun save(person: Person): Person
    suspend fun findByDni(dni: Long): Person?
    suspend fun findAll(): Flow<Person>
}