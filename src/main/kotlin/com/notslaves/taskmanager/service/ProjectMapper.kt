package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.entity.ProjectEntity
import com.notslaves.taskmanager.model.Project
import com.notslaves.taskmanager.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class ProjectMapper(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository
) {

    fun modelToEntity(model: Project): ProjectEntity {
        val entity = ProjectEntity()
        entity.id = model.id
        entity.name = model.name
        entity.description = model.description
        entity.created = model.created
        entity.user = model.user.let {
            userRepository.findById(it).orElse(null)
                ?: throw IllegalArgumentException("User with id $it not found")
        }
        return entity
    }

    fun entityToModel(entity: ProjectEntity): Project = Project(
        entity.id,
        entity.name!!,
        entity.description,
        entity.created,
        userMapper.entityToModel(entity.user!!).id!!,
    )
}