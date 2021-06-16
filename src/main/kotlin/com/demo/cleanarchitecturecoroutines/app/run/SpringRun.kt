package com.demo.cleanarchitecturecoroutines.app.run

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories("com.demo.cleanarchitecturecoroutines.repository")
//@EntityScan("repository")
@ComponentScan(basePackages = ["com.demo.cleanarchitecturecoroutines"])
class SpringRun

fun main(args: Array<String>) {
    runApplication<SpringRun>(*args)
}
