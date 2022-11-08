package com.thoughtworks.twitterlikebackend.model


import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "tweets")
class Tweet(
        var text: String,
        @JsonManagedReference
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        var user: User? = null,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long ?= null
)