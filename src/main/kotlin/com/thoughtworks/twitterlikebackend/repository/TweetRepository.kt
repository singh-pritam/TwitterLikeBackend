package com.thoughtworks.twitterlikebackend.repository

import com.thoughtworks.twitterlikebackend.model.Tweet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TweetRepository: JpaRepository<Tweet, Long> {
}