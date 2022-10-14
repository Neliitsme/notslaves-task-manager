package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.TaskEntity
import com.notslaves.taskmanager.entity.TaskStatusEntity
import com.notslaves.taskmanager.model.TaskStatus
import org.springframework.stereotype.Component

@Component
class TaskStatusMapper(
    private val taskMapper: TaskMapper
) {

    fun modelToEntity(model: TaskStatus): TaskStatusEntity{
        var entity = TaskStatusEntity()
        entity.id = model.id
        entity.name = model.name
        entity.tasks = model.tasks?.map { taskMapper.modelToEntity(it) } as MutableList<TaskEntity>?
        return entity
    }

    fun entityToModel(entity: TaskStatusEntity) {

    }
}