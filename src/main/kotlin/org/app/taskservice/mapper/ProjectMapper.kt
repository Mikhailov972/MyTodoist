package org.app.taskservice.mapper

import org.app.taskservice.controller.dto.Project
import org.app.taskservice.dao.entity.ProjectEntity
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import org.springframework.stereotype.Component


@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ProjectMapper {

    fun projectToProjectEntity(project: Project): ProjectEntity

    fun projectEntityToProject(project: ProjectEntity): Project
}