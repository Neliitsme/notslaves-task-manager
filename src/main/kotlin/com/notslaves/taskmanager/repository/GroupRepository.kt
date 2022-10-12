package com.notslaves.taskmanager.repository

import com.notslaves.taskmanager.entity.GroupEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GroupRepository : JpaRepository<GroupEntity, UUID> {
    fun findByName(name: String): GroupEntity?
    fun deleteByName(name: String)
}