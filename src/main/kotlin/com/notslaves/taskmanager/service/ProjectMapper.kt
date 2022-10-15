package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.ProjectEntity
import com.notslaves.taskmanager.entity.TaskEntity
import com.notslaves.taskmanager.model.Project
import org.springframework.stereotype.Component

@Component
class ProjectMapper(
    private val userMapper: UserMapper,
    private val tasksMapper: TaskMapper,
) {

    fun modelToEntity(model: Project): ProjectEntity {
        val entity = ProjectEntity()
        entity.id = model.id
        entity.name = model.name
        entity.description = model.description
        entity.created = model.created
        entity.user = userMapper.modelToEntity(model.user)
        entity.tasks = model.tasks?.map { tasksMapper.modelToEntity(it) }?.toMutableList()
        return entity
    }

    fun entityToModel(entity: ProjectEntity): Project = Project(
        entity.id!!,
        entity.name!!,
        entity.description!!,
        entity.created!!,
        userMapper.entityToModel(entity.user!!),
        entity.tasks?.map { tasksMapper.entityToModel(it) }?.toMutableList() ?: mutableListOf()
    )
}