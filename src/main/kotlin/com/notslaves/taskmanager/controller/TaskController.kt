package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.model.Task
import com.notslaves.taskmanager.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api/v1/tasks")
class TaskController(private val service: TaskService) {
    // Todo
    @GetMapping
    fun getAllTasks() = null

    @PutMapping("/{id}")
    fun changeTaskStatus() = null

    @GetMapping("/{id}")
    fun getTask() = null

    @GetMapping("/project/{id}")
    fun getTasksByProjectId() = null

    // Todo
    // Would be nice to add finding tasks by status within a project
    @GetMapping("/status/{id}")
    fun getTasksByStatusId() = null

    @DeleteMapping("/{id}")
    fun deleteTask() = null

    // For that niche use case. Not obligatory.
    @DeleteMapping("/status/{id}")
    fun deleteAllTasksByStatusId() = null

    @PatchMapping("/{id}")
    fun modifyTask() = null

}