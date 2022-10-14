package com.notslaves.taskmanager.model

import java.util.Date

data class Task(
    val id: Int?,
    val name: String,
    val description: String?,
    val created: Date,
    val status: TaskStatus,
    val project: Project,
)