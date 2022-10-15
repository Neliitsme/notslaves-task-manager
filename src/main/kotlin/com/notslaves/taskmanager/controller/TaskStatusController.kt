package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.model.TaskStatus
import com.notslaves.taskmanager.service.TaskStatusService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/taskstatuses")
class TaskStatusController(private val service: TaskStatusService) {
    // Todo
    @GetMapping
    fun getAllStatuses(): List<TaskStatus> = service.getAllStatuses()

    @GetMapping("/{id}")
    fun getStatus(@PathVariable("id") id: Int): TaskStatus? =
        service.getStatus(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Task status with id $id not found"
        )

    @PostMapping
    fun createStatus(@RequestBody @Validated taskStatus: TaskStatus): TaskStatus = service.createStatus(taskStatus)

    @DeleteMapping("/{id}")
    fun deleteStatus(@PathVariable("id") id: Int) = service.deleteStatus(id)

    // Todo: Could make a null check by making and id put request
    // @PutMapping("/{id}")
    @PutMapping()
    fun modifyStatus(@RequestBody @Validated taskStatus: TaskStatus): TaskStatus? = service.modifyStatus(taskStatus)
}