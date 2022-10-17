package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.TaskEntity
import com.notslaves.taskmanager.model.Task
import com.notslaves.taskmanager.repository.ProjectRepository
import com.notslaves.taskmanager.repository.TaskStatusRepository
import org.springframework.stereotype.Component

@Component
class TaskMapper(
    private val taskStatusMapper: TaskStatusMapper,
    private val projectMapper: ProjectMapper,
    private val taskStatusRepository: TaskStatusRepository,
    private val projectRepository: ProjectRepository
) {
    fun modelToEntity(model: Task): TaskEntity {
        val entity = TaskEntity()
        entity.id = model.id
        entity.name = model.name
        entity.description = model.description
        entity.created = model.created
        entity.status = model.status.let {
            taskStatusRepository.findById(it).orElse(null)
                ?: throw IllegalArgumentException("Task status with id $it not found")
        }
        entity.project = model.project.let {
            projectRepository.findById(it).orElse(null)
                ?: throw IllegalArgumentException("Project with id $it not found")
        }
        return entity
    }

    fun entityToModel(entity: TaskEntity): Task = Task(
        entity.id,
        entity.name!!,
        entity.description,
        entity.created,
        taskStatusMapper.entityToModel(entity.status!!).id!!,
        projectMapper.entityToModel(entity.project!!).id!!
    )
}