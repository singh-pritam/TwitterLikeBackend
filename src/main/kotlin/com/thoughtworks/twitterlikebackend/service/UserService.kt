package com.thoughtworks.twitterlikebackend.service

import com.thoughtworks.twitterlikebackend.model.User
import com.thoughtworks.twitterlikebackend.repository.UserRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(userId: Long) = userRepository.findById(userId);
    fun createNewUser(user: User): Any = userRepository.save(user)


}