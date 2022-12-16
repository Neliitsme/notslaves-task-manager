package com.notslaves.taskmanager.entity

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "username", unique = true)
    var username: String? = null

    @Column(name = "created")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    var created: Date? = null

    @OneToMany(mappedBy = "user")
    var projects: MutableList<ProjectEntity>? = null

}