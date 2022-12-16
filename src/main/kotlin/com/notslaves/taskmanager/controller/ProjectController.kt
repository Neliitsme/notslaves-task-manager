package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.model.Project
import com.notslaves.taskmanager.service.ProjectService
import com.notslaves.taskmanager.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/projects")
class ProjectController(
    private val projectService: ProjectService,
    private val userService: UserService
) {
    @GetMapping
    fun getAllProjects(): List<Project> = projectService.getAllProject()

    @GetMapping("/{id}")
    fun getProject(@PathVariable("id") id: Int): Project? =
        projectService.getProject(id)
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Task status with id $id not found"
            )

    // Todo: Fix
    // This way causes 2 requests to db. Here and in ProjectMapper
    @GetMapping("/user/{id}")
    fun getAllProjectsByUserId(@PathVariable("id") id: Int): List<Project> {
        userService.getUser(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "User with id $id not found"
        )
        return projectService.getAllProjectsByUserId(id)
    }

    @PostMapping
    fun createProject(@RequestBody @Validated project: Project): Project = projectService.createProject(project)

    @DeleteMapping("/{id}")
    fun deleteProject(@PathVariable("id") id: Int) = projectService.deleteProject(id)

    @PutMapping("/{id}")
    fun modifyProject(@PathVariable("id") id: Int, @RequestBody @Validated project: Project): Project? =
        projectService.modifyProject(id, project) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Project with id $id not found"
        )
}