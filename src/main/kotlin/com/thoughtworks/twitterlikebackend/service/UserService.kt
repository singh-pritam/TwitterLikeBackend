package com.thoughtworks.twitterlikebackend.service

import com.thoughtworks.twitterlikebackend.entity.User
import com.thoughtworks.twitterlikebackend.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import kotlin.Exception

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(userId: Long): Any {
        if(userRepository.existsById(userId))
          return userRepository.findById(userId)
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
    }
    fun createNewUser(user: User): User {
        try {
            return userRepository.save(user)
        } catch (exception: Exception) {
            throw ResponseStatusException(HttpStatus.ALREADY_REPORTED, "User already exist", exception)
        }
    }

    fun getUsers(): List<List<String>> = userRepository.findAllUsers();
    fun removeUser(userId: Long) {
        if(userRepository.existsById(userId))
            return userRepository.deleteById(userId);
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
    }


}