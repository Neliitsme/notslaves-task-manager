package com.notslaves.taskmanager.model

import java.util.Date

data class Project(
    val id: Int?,
    val name: String,
    val description: String?,
    val created: Date,
    val user: User,
)
