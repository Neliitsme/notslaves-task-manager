package com.notslaves.taskmanager.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Int? = null
}