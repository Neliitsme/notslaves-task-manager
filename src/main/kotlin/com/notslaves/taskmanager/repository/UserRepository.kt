package com.notslaves.taskmanager.repository

import com.notslaves.taskmanager.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Int> {
    fun findByUsername(username: String): UserEntity?
    fun deleteByUsername(username: String)
}