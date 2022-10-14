package com.notslaves.taskmanager.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "projects")
class ProjectEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "name", unique = true)
    var name: String? = null

    @Lob
    @Column(name = "description")
    var description: String? = null

    @Column(name = "created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    var created: Date? = null

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: UserEntity? = null

    @OneToMany(mappedBy = "project")
    var tasks: MutableList<TaskEntity>? = null
}