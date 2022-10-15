package com.notslaves.taskmanager.model

import java.util.Date

data class User(
    val id: Int?,
    val username: String,
    val created: Date,
    val projects: MutableList<Project>?,
)
