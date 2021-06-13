package com.demo.cleanarchitecturecoroutines.client

import org.springframework.web.reactive.function.client.WebClient

class FilmClient(host:String, private val apiKey: String, webClient: WebClient) {
}