package com.notslaves.taskmanager.model

data class TaskStatus(
    val id: Int?,
    val name: String,
    val tasks: MutableList<Task>?,
)
