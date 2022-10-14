package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.TaskEntity
import com.notslaves.taskmanager.entity.TaskStatusEntity
import com.notslaves.taskmanager.model.Task
import com.notslaves.taskmanager.model.TaskStatus
import org.springframework.stereotype.Component

@Component
class TaskStatusMapper(
    private val taskMapper: TaskMapper
) {

    fun modelToEntity(model: TaskStatus): TaskStatusEntity{
        val entity = TaskStatusEntity()
        entity.id = model.id
        entity.name = model.name
        entity.tasks = model.tasks?.map { taskMapper.modelToEntity(it) } as MutableList<TaskEntity>?
        return entity
    }

    fun entityToModel(entity: TaskStatusEntity): TaskStatus = TaskStatus(
        entity.id!!,
        entity.name!!,
        entity.tasks?.map { taskMapper.entityToModel(it) } as MutableList<Task>?
    )
}