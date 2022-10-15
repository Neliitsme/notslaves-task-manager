package com.notslaves.taskmanager.service

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
        entity.projects = model.projects?.map { projectMapper.modelToEntity(it) }?.toMutableList()
        return entity
    }

    fun entityToModel(entity: UserEntity): User = User(
        entity.id!!,
        entity.username!!,
        entity.created!!,
        entity.projects?.map { projectMapper.entityToModel(it) }?.toMutableList() ?: mutableListOf()
    )
}