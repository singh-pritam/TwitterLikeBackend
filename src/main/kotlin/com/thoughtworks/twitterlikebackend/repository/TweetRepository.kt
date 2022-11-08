package com.thoughtworks.twitterlikebackend.repository

import com.thoughtworks.twitterlikebackend.model.Tweet
import com.thoughtworks.twitterlikebackend.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TweetRepository: JpaRepository<Tweet, Long> {
    @Query("SELECT tweet.id,tweet.text FROM Tweet tweet  WHERE tweet.user = :user")
    fun findTweetByUser(@Param("user") user: User) : List<Object>?
}