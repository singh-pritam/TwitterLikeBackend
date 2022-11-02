package com.thoughtworks.twitterlikebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TwitterLikeBackendApplication

fun main(args: Array<String>) {
	runApplication<TwitterLikeBackendApplication>(*args)
}
