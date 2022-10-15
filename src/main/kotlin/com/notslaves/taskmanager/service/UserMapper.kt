package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.UserEntity
import com.notslaves.taskmanager.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun modelToEntity(model: User): UserEntity {
        val entity = UserEntity()
        entity.id = model.id
        entity.username = model.username
        entity.created = model.created
        return entity
    }

    fun entityToModel(entity: UserEntity): User = User(
        entity.id!!,
        entity.username!!,
        entity.created!!,
    )
}