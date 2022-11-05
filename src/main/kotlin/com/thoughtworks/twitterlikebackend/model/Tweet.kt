package com.thoughtworks.twitterlikebackend.model


import javax.persistence.*

@Entity
@Table(name = "tweets")
class Tweet(
        var text: String,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        var user: User? = null,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long ?= null
)