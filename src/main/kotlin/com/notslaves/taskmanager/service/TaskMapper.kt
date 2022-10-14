package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.TaskEntity
import com.notslaves.taskmanager.model.Task
import org.springframework.stereotype.Component

@Component
class TaskMapper(
    private val taskStatusMapper: TaskStatusMapper,
    private val projectMapper: ProjectMapper
) {
    fun modelToEntity(model: Task): TaskEntity {
        val entity = TaskEntity()
        entity.id = model.id
        entity.name = model.name
        entity.description = model.description
        entity.created = model.created
        entity.status = taskStatusMapper.modelToEntity(model.status)
        entity.project = projectMapper.modelToEntity(model.project)
        return entity
    }

    fun entityToModel(entity: TaskEntity): Task = Task(
        entity.id!!,
        entity.name!!,
        entity.description!!,
        entity.created!!,
        taskStatusMapper.entityToModel(entity.status!!),
        projectMapper.entityToModel(entity.project!!)
    )
}