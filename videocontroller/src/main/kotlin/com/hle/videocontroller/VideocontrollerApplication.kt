package com.hle.videocontroller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VideocontrollerApplication

fun main(args: Array<String>) {
	runApplication<VideocontrollerApplication>(*args)
}
