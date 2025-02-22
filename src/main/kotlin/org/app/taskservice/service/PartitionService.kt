package org.app.taskservice.service

import org.app.taskservice.dao.entity.PartitionEntity
import org.app.taskservice.repository.PartitionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PartitionService(private val partitionRepository: PartitionRepository) {

    @Transactional
    fun save(partitionEntity: PartitionEntity): PartitionEntity {
        return partitionRepository.save(partitionEntity)
    }

    @Transactional
    fun deleteAll() {
        partitionRepository.deleteAll()
    }
}