package com.thoughtworks.twitterlikebackend.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User(
        val name: String,
        @Column(name = "user_name", unique = true)
        val userName: String,
        val email: String,
        @Id
        //@GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0
)