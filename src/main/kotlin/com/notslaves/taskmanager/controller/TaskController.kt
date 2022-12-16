package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.model.Task
import com.notslaves.taskmanager.service.ProjectService
import com.notslaves.taskmanager.service.TaskService
import com.notslaves.taskmanager.service.TaskStatusService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/tasks")
class TaskController(
    private val taskService: TaskService,
    private val taskStatusService: TaskStatusService,
    private val projectService: ProjectService
) {
    @GetMapping
    fun getAllTasks(): List<Task> = taskService.getAllTasks()

    @PatchMapping("/{taskId}/status/{statusId}")
    fun changeTaskStatus(@PathVariable("taskId") taskId: Int, @PathVariable("statusId") statusId: Int): Task? {
        taskStatusService.getStatus(statusId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Task status with id $statusId not found"
        )
        return taskService.changeTaskStatus(taskId, statusId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Task  with id $taskId not found"
        )
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable("id") id: Int): Task? =
        taskService.getTask(id)
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Task  with id $id not found"
            )

    @GetMapping("/project/{id}")
    fun getAllTasksByProjectId(@PathVariable("id") id: Int): List<Task> {
        projectService.getProject(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Project with id $id not found"
        )
        return taskService.getAllTasksByProjectId(id)
    }

    @PostMapping
    fun createTask(@RequestBody @Validated task: Task): Task = taskService.createTask(task)

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable("id") id: Int) = taskService.deleteTask(id)

    @PutMapping("/{id}")
    fun modifyTask(@PathVariable("id") id: Int, @RequestBody @Validated task: Task) =
        taskService.modifyTask(id, task) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Task with id $id not found"
        )
}