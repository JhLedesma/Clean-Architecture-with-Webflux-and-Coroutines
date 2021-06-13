package com.demo.cleanarchitecturecoroutines.utils

import com.demo.cleanarchitecturecoroutines.core.person.model.Person
import com.demo.cleanarchitecturecoroutines.repository.entity.PersonDocument

class ModelMapper {

    fun toDto(personDocument: PersonDocument): Person =
        Person(personDocument.dni, personDocument.name, personDocument.book, personDocument.film)

    fun toDocument(person: Person): PersonDocument =
        PersonDocument(person.dni, person.name, person.book, person.film)
}


