package com.demo.cleanarchitecturecoroutines.repository.adapter

import com.demo.cleanarchitecturecoroutines.core.person.model.Person
import com.demo.cleanarchitecturecoroutines.repository.PersonRepository
import com.demo.cleanarchitecturecoroutines.repository.dao.PersonDao
import com.demo.cleanarchitecturecoroutines.utils.ModelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull

class PersonAdapterRepository(private val personDao: PersonDao, private val modelMapper: ModelMapper): PersonRepository {

    override suspend fun save(person: Person): Person {
        return personDao.save(modelMapper.toDocument(person)).awaitFirst().let { modelMapper.toDto(it) }
    }

    override suspend fun findByDni(dni: Long): Person? {
        return personDao.findById(dni).awaitFirstOrNull()?.let { modelMapper.toDto(it) }
    }

    override suspend fun findAll(): Flow<Person> {
        return personDao.findAll().asFlow().map { modelMapper.toDto(it) }
    }
}


