package com.notslaves.taskmanager.repository

import com.notslaves.taskmanager.entity.TaskStatusEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TaskStatusRepository : JpaRepository<TaskStatusEntity, Int>