package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.ProjectEntity
import com.notslaves.taskmanager.entity.TaskEntity
import com.notslaves.taskmanager.entity.UserEntity
import com.notslaves.taskmanager.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val projectMapper: ProjectMapper
) {
    fun modelToEntity(model: User): UserEntity {
        val entity = UserEntity()
        entity.id = model.id
        entity.username = model.username
        entity.created = model.created
        entity.projects = model.projects?.map { projectMapper.modelToEntity(it) } as MutableList<ProjectEntity>?
        return entity
    }

    fun entityToModel(entity: UserEntity) {

    }
}