package com.thoughtworks.twitterlikebackend.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
        var name: String,
        @Column(name = "user_name", unique = true)
        var userName: String,
        val email: String,
        var password: String,
        var birthday: String? = null,
        var gender: String? = null,
        var bio : String? = null,
        var Location: String? = null,
        var Website: String? = null,
        @JsonBackReference
        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var tweetList: MutableList<Tweet>? = null,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?
)