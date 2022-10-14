package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.service.TaskStatusService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/taskstatuses")
class TaskStatusController(private val service: TaskStatusService) {
    // Todo
    @GetMapping
    fun getAllStatuses() = null

    @GetMapping("/{id}")
    fun getStatus(@PathVariable("id") id: Int) = null

    @DeleteMapping("/{id}")
    fun deleteStatus(@PathVariable("id") id: Int) = null

    @PatchMapping("/{id}")
    fun modifyStatus(@PathVariable("id") id: Int) = null
}