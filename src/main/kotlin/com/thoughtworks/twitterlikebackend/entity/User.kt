package com.thoughtworks.twitterlikebackend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
        @Column(name = "name")
        val name: String,
        @Column(name = "user_name", unique = true)
        val userName: String,
        @Column(name = "email", unique = true)
        val email: String,
        @Column(name = "password")
        val password: String,
        @Column(name = "birthday")
        val birthday: String? = null,
        @Column(name = "gender")
        val gender: String? = null,
        @Column(name = "bio")
        val bio : String? = null,
        @Column(name = "location")
        val location: String? = null,
        @Column(name = "website")
        val website: String? = null,
        @JsonBackReference
        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        val tweetList: MutableList<Tweet>? = null,
        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "users_relations",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "follower_id")])
        val followers: Set<User>? = null,
        @ManyToMany(mappedBy = "followers")
        val following: Set<User>?=null,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long?=null
) {
    fun compare(password: String): Boolean {
            return password == this.password

    }
}