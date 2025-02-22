package org.app.taskservice.repository

import java.util.UUID
import org.app.taskservice.dao.entity.LabelEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LabelRepository : JpaRepository<LabelEntity, UUID> {
}