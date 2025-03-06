package org.app.taskservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class TaskServiceApplication

fun main(args: Array<String>) {
    runApplication<TaskServiceApplication>(*args)
}
