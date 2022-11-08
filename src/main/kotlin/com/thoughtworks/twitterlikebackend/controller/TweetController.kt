package com.thoughtworks.twitterlikebackend.controller

import com.thoughtworks.twitterlikebackend.model.Tweet
import com.thoughtworks.twitterlikebackend.service.TweetService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TweetController(private val tweetService: TweetService) {
    @PostMapping("/{userName}/tweet")
    fun postTweet(@PathVariable userName: String, @RequestBody tweet: Tweet) = tweetService.createTweet(tweet, userName);

    @GetMapping("/tweet/{tweetId}")
    fun getTweetById(@PathVariable tweetId:Long) = tweetService.getTweetById(tweetId);

    @GetMapping("{userName}/tweets")
    fun getAllTweetsOfAUser(@PathVariable userName: String) = tweetService.getAllTweetsByUserName(userName);

}