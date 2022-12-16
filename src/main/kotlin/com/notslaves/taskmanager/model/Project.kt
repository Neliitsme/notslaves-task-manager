package com.notslaves.taskmanager.model

import java.util.Date

data class Project(
    val id: Int?,
    val name: String,
    val description: String?,
    var created: Date?,
    val user: Int,
)
