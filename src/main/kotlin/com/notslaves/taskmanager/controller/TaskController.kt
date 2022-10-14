package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.model.Task
import com.notslaves.taskmanager.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/tasks")
class TaskController(private val service: TaskService) {
    // Todo
    @GetMapping
    fun getAllTasks() = null

    @PutMapping("/{id}")
    fun changeTaskStatus(@PathVariable("id") id: Int) = null

    @GetMapping("/{id}")
    fun getTask(@PathVariable("id") id: Int) = null

    @GetMapping("/project/{id}")
    fun getTasksByProjectId(@PathVariable("id") id: Int) = null

    // Todo
    // Would be nice to add finding tasks by status within a project
    @GetMapping("/status/{id}")
    fun getTasksByStatusId(@PathVariable("id") id: Int) = null

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable("id") id: Int) = null

    // For that niche use case. Not obligatory.
    @DeleteMapping("/status/{id}")
    fun deleteAllTasksByStatusId(@PathVariable("id") id: Int) = null

    @PatchMapping("/{id}")
    fun modifyTask(@PathVariable("id") id: Int) = null

}