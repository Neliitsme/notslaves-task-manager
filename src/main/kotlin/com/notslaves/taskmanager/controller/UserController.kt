package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val service: UserService) {
    // Todo
    // Todo: finding/deleting by username would've been nice to have
    @GetMapping
    fun getAllUsers() = null

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Int) = null

    @DeleteMapping("/{id")
    fun deleteUser(@PathVariable("id") id: Int) = null

    @PatchMapping("/id")
    fun modifyUser(@PathVariable("id") id: Int) = null
}