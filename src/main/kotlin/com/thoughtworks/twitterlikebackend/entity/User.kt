package com.thoughtworks.twitterlikebackend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
        @Column(name = "name")
        var name: String,
        @Column(name = "user_name", unique = true)
        var userName: String,
        @Column(name = "email", unique = true)
        val email: String,
        @Column(name = "password")
        var password: String,
        @Column(name = "birthday")
        var birthday: String? = null,
        @Column(name = "gender")
        var gender: String? = null,
        @Column(name = "bio")
        var bio : String? = null,
        @Column(name = "location")
        var location: String? = null,
        @Column(name = "website")
        var website: String? = null,
        @JsonBackReference
        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var tweetList: MutableList<Tweet>? = null,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long?=null
)