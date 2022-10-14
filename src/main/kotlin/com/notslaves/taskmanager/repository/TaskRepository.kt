package com.notslaves.taskmanager.repository

import com.notslaves.taskmanager.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<TaskEntity, Int> {
    fun findAllByProjectId(projectId: Int): List<TaskEntity>?
    fun findAllByStatusId(statusId: Int): List<TaskEntity>?

    // Niche use case example: Delete all tasks marked as "Won't/Can't do"
    fun deleteAllByStatusId(statusId: Int)
}