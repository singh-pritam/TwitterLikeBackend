package com.thoughtworks.twitterlikebackend.repository

import com.thoughtworks.twitterlikebackend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Repository
interface UserRepository : JpaRepository<User, Long> {
    @Query("SELECT userName, email, name FROM User")
    fun findAllUsers(): List<List<String>>
    fun findByUserName(userName: String): User?

    @Query("SELECT userName, email, name FROM User WHERE id = :userId")
    fun findUserById(userId: Long): List<String>
}