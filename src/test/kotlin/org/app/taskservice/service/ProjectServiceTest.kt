package org.app.taskservice.service

import java.util.UUID
import org.app.taskservice.dao.entity.LabelColor
import org.app.taskservice.dao.entity.LabelEntity
import org.app.taskservice.dao.entity.PartitionEntity
import org.app.taskservice.dao.entity.ProjectEntity
import org.app.taskservice.dao.entity.TaskEntity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private lateinit var projectService: ProjectService

    @Autowired
    private lateinit var partitionService: PartitionService

    @Autowired
    private lateinit var taskService: TaskService

    @Autowired
    private lateinit var labelService: LabelService


    @BeforeEach
    fun setUp() {
        projectService.deleteAll()
        partitionService.deleteAll()
    }

    @Test
    fun test() {
        val project = ProjectEntity(null, "Developer", UUID.randomUUID(), mutableListOf())
        val devProject = projectService.createProject(project)

        val partition = PartitionEntity(null, "Новый объект", devProject, emptyList())

        devProject.partitions.add(partition)

        projectService.createProject(devProject)

        val test = projectService.findAll()[0]
        println(test)
    }

    @Test
    fun test2() {
        // Создание родительского объекта (проект)
        val project = ProjectEntity(null, "Developer", UUID.randomUUID(), mutableListOf())

        // Сохранение проекта
        val devProject = projectService.createProject(project)

        // Создание дочернего объекта (partition) и присвоение проекта
        val partition = PartitionEntity(null, "Новый объект", devProject, emptyList())

        // Добавление дочернего объекта в список родительского объекта
        devProject.partitions.add(partition)

        // Убедитесь, что связь между дочерним объектом и родительским установлена
        partition.project = devProject

        // Сохранение дочернего объекта вручную
        partitionService.save(partition) // Если у вас есть отдельный метод для создания partition

        // Сохранение родительского объекта
        projectService.createProject(devProject)

        // Получение сохранённого объекта для проверки
        val test = projectService.findAll()[0]
        println(test)
    }


}