package com.thoughtworks.twitterlikebackend.service

import com.thoughtworks.twitterlikebackend.entity.Tweet
import com.thoughtworks.twitterlikebackend.entity.User
import com.thoughtworks.twitterlikebackend.repository.TweetRepository
import com.thoughtworks.twitterlikebackend.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class TweetService(private val tweetRepository: TweetRepository, private val userRepository: UserRepository) {
    fun createTweet(tweet: Tweet, userName: String) {
        var twitterUser: User? = userRepository.findByUserName(userName);
        tweet.user = twitterUser;
        val newTweet: Tweet = tweetRepository.save(tweet);
        twitterUser?.tweetList?.add(newTweet);
    }

    fun getTweetById(tweetId: Long): Optional<Tweet> {
        if(tweetRepository.existsById(tweetId))
            return tweetRepository.findById(tweetId)
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Tweet doesn't exist")
    }

    fun getAllTweetsByUserName(userName: String): List<Object>? {
        val user: User? = userRepository.findByUserName(userName);
        return tweetRepository.findTweetByUser(user);
    }

    fun getAllTweets(): List<Object> {
        return tweetRepository.findAllTweets();
    }

}
