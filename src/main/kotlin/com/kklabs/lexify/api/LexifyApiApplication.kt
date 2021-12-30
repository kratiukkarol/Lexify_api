package com.kklabs.lexify.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LexifyApiApplication

fun main(args: Array<String>) {
    runApplication<LexifyApiApplication>(*args)
}
