package com.notslaves.taskmanager.model

data class Group(
    val name: String,
    val students: List<Student>?
)