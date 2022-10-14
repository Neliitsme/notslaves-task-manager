package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.service.ProjectService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/projects")
class ProjectController(private val service: ProjectService) {
    // Todo
    @GetMapping
    fun getAllProjects() = null

    @GetMapping("/{id}")
    fun getProject(@PathVariable("id") id: Int) = null

    @GetMapping("/user/{id}")
    fun getAllProjectByUserId(@PathVariable("id") id: Int) = null

    @DeleteMapping("/{id}")
    fun deleteProject(@PathVariable("id") id: Int) = null

    @PatchMapping("/{id}")
    fun modifyProject(@PathVariable("id") id: Int) = null
}