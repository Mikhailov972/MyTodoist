package org.app.taskservice.controller

import java.util.UUID
import org.app.taskservice.controller.dto.Project
import org.app.taskservice.mapper.ProjectMapper
import org.app.taskservice.service.ProjectService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/project")
class ProjectController(
    private val projectService: ProjectService,
    private val projectMapper: ProjectMapper
) {

    @PostMapping("/create")
    fun createProject(@RequestBody project: Project): UUID {
        val project1 = projectMapper.projectToProjectEntity(project)
        return projectService.createProject(project1).id!!
    }

    @GetMapping("/all")
    fun getAllProjects(): List<Project> {
        return projectService.findAll().map { projectMapper.projectEntityToProject(it) }.toList()
    }
}