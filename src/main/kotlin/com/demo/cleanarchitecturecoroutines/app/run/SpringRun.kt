package com.demo.cleanarchitecturecoroutines.app.run

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories("com.demo.cleanarchitecturecoroutines.repository")
//@EntityScan("repository")
@ComponentScan(basePackages= ["com.demo.cleanarchitecturecoroutines"])
class SpringRun

fun main(args: Array<String>) {
    SpringApplication.run(SpringRun::class.java, *args)
}
