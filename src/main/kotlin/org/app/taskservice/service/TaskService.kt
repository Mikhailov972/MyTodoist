package org.app.taskservice.service

import org.app.taskservice.dao.entity.TaskEntity
import org.app.taskservice.dao.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun save(task: TaskEntity): TaskEntity {
        return taskRepository.save(task)
    }
}