package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.model.TaskStatus
import com.notslaves.taskmanager.repository.TaskStatusRepository
import org.springframework.stereotype.Service

@Service
class TaskStatusService(
    private val mapper: TaskStatusMapper,
    private val repository: TaskStatusRepository
) {
    fun getAllStatuses(): List<TaskStatus> = repository.findAll().map { mapper.entityToModel(it) }

    fun getStatus(id: Int): TaskStatus? = repository.findById(id)
        .orElse(null)?.let { mapper.entityToModel(it) }

    fun deleteStatus(id: Int) = repository.deleteById(id)

    fun createStatus(taskStatus: TaskStatus): TaskStatus {
        val entity = mapper.modelToEntity(taskStatus)
        return mapper.entityToModel(repository.save(entity))
    }

    fun modifyStatus(id: Int, taskStatus: TaskStatus): TaskStatus? {
        val foundTaskStatus = getStatus(id)
        return foundTaskStatus?.let {
            repository.save(mapper.modelToEntity(taskStatus))
            taskStatus
        }
    }
}