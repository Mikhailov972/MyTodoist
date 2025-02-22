package org.app.taskservice.service

import org.app.taskservice.dao.entity.ProjectEntity
import org.app.taskservice.repository.ProjectRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProjectService(private val projectRepository: ProjectRepository) {

    @Transactional
    fun createProject(projectEntity: ProjectEntity): ProjectEntity {
        return projectRepository.save(projectEntity)
    }

    @Transactional
    fun findAll(): MutableList<ProjectEntity> {
        return projectRepository.findAll()
    }

    fun deleteAll() {
        projectRepository.deleteAll()
    }
}