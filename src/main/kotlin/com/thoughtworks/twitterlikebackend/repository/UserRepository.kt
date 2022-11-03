package com.thoughtworks.twitterlikebackend.repository

import com.thoughtworks.twitterlikebackend.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUserName(userName: String): User?
}