package com.notslaves.taskmanager.repository

import com.notslaves.taskmanager.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StudentRepository : JpaRepository<StudentEntity, UUID>
