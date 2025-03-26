package org.app.taskservice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/project")
class ProjectController() {

    @GetMapping("/hello")
    fun helloWorld(): String {
        return "Hello World!"
    }
}