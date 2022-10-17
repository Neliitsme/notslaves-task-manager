package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.model.User
import com.notslaves.taskmanager.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val mapper: UserMapper,
    private val repository: UserRepository
) {
    fun getAllUsers(): List<User> = repository.findAll().map { mapper.entityToModel(it) }

    fun getUser(id: Int): User? = repository.findById(id)
        .orElse(null)?.let { mapper.entityToModel(it) }

    fun createUser(user: User): User {
        val entity = mapper.modelToEntity(user)
        return mapper.entityToModel(repository.save(entity))
    }

    fun deleteUser(id: Int) = repository.deleteById(id)

    // Todo: Fix
    // Not sure having a data classes with var date is good idea.
    // Not sure how to persist original date w/o creating a return-type data class in general.
    fun modifyUser(id: Int, user: User): User? {
        val foundUser = getUser(id)
        return foundUser?.let {
            user.created = foundUser.created
            repository.save(mapper.modelToEntity(user))
            user
        }
    }
}