package org.app.taskservice.dao.repository

import java.util.UUID
import org.app.taskservice.dao.entity.PartitionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PartitionRepository : JpaRepository<PartitionEntity, UUID>