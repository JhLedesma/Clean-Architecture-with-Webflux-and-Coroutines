package com.demo.cleanarchitecturecoroutines.repository.dao

import com.demo.cleanarchitecturecoroutines.repository.entity.PersonDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface PersonDao : ReactiveMongoRepository<PersonDocument, Long>



