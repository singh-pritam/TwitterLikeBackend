package com.thoughtworks.twitterlikebackend.repository

import com.thoughtworks.twitterlikebackend.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Objects

@Repository
interface UserRepository : JpaRepository<User, Long> {
    @Query("SELECT userName, email, name FROM User")
    fun findAllUsers(): List<Object>
    fun findByUserName(userName: String): User
}