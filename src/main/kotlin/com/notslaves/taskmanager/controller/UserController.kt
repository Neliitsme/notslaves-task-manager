package com.notslaves.taskmanager.controller

import com.notslaves.taskmanager.model.User
import com.notslaves.taskmanager.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val service: UserService) {
    // Todo: finding/deleting by username would've been nice to have
    @GetMapping
    fun getAllUsers(): List<User> = service.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Int): User? =
        service.getUser(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Task status with id $id not found"
        )

    @PostMapping
    fun createUser(@RequestBody @Validated user: User): User = service.createUser(user)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: Int) = service.deleteUser(id)

    @PutMapping("/{id}")
    fun modifyUser(@PathVariable("id") id: Int, @RequestBody @Validated user: User): User? = service.modifyUser(id, user)
        ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Task status with id ${user.id} not found"
        )
}