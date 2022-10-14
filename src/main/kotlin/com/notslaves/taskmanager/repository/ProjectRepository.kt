package com.notslaves.taskmanager.repository

import com.notslaves.taskmanager.entity.ProjectEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<ProjectEntity, Int> {
    fun findByName(name: String): ProjectEntity?
    fun findAllByUserId(userId: Int): List<ProjectEntity>?

    // Potentially could be nice
//    fun findAllByUsername(username: String): List<ProjectEntity>

}