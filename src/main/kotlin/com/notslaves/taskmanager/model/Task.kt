package com.notslaves.taskmanager.model

import java.util.Date

data class Task(
    val id: Int?,
    val name: String,
    val description: String?,
    var created: Date?,
    // Todo: maybe switch to stringified status
    var status: Int,
    val project: Int,
)