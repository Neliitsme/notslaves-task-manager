package com.notslaves.taskmanager.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tasks")
class TaskEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "name")
    var name: String? = null

    @Lob
    @Column(name = "description")
    var description: String? = null

    @Column(name = "created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    var created: Date? = null

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    var status: TaskStatusEntity? = null

    @ManyToOne(cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    var project: ProjectEntity? = null
}