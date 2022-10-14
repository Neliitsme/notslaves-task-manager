package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(
    private val mapper: TaskMapper,
    private val repository: TaskRepository
) {
}