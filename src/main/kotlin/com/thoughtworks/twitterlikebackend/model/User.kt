package com.thoughtworks.twitterlikebackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class User(
        val name: String,
        val user_name: String,
        val email: String
){
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0
}