package com.notslaves.taskmanager.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "task_statuses")
class TaskStatusEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "name", unique = true)
    var name: String? = null

    @OneToMany(mappedBy = "status")
    var tasks: List<TaskEntity>? = null
}