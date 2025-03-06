package org.app.taskservice.controller

import java.util.UUID
import org.app.taskservice.controller.dto.Project
import org.app.taskservice.mapper.ProjectMapper
import org.app.taskservice.service.ProjectService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/project")
class ProjectController(
    private val projectService: ProjectService,
    private val projectMapper: ProjectMapper
) {

    @PostMapping("/create")
    fun createProject(project: Project): UUID {
        val project1 = projectMapper.projectToProjectEntity(project)
        return projectService.createProject(project1).id!!
    }
}