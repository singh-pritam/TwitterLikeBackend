package com.thoughtworks.twitterlikebackend.service

import com.thoughtworks.twitterlikebackend.model.User
import com.thoughtworks.twitterlikebackend.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(userId: Long): Optional<User> {
        if(userRepository.existsById(userId))
          return userRepository.findById(userId)
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User ID doesn't exist")
    }
    fun createNewUser(user: User): User {
        val userName: User? = userRepository.findByUserName(user.userName)
        if(userName == null)
            return userRepository.save(user);
        else
            throw ResponseStatusException(HttpStatus.ALREADY_REPORTED, "User already exist")
    }
    fun getUsers(): List<User> = userRepository.findAll();



}