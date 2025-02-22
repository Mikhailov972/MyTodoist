package org.app.taskservice.service

import org.app.taskservice.dao.entity.LabelEntity
import org.app.taskservice.repository.LabelRepository
import org.springframework.stereotype.Service

@Service
class LabelService(private val labelRepository: LabelRepository) {

    fun saveLabel(label: LabelEntity): LabelEntity {
        return labelRepository.save(label)
    }
}