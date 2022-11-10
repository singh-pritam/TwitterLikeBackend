package com.thoughtworks.twitterlikebackend.service

import com.thoughtworks.twitterlikebackend.entity.User
import com.thoughtworks.twitterlikebackend.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.web.server.ResponseStatusException

class UserServiceTest{

    private val userRepository:UserRepository = mockk(relaxed = true)
    private val userService = UserService(userRepository)

    @Test
    internal fun `should verify if repository is getting called exactly once when user exists`(){

        val id: Long = 1

        every { userRepository.existsById(id) } returns true
        userService.getUserById(id)

        verify(exactly = 1) { userRepository.findById(id) }

    }

    @Test
    internal fun `should throw exception if the user doesn't exist`() {
        val id: Long = 2

        every { userRepository.existsById(id) } returns false

        assertThrows(ResponseStatusException::class.java) {
            userService.getUserById(id)
        }
    }

    @Test
    internal fun `should return user if the user is created`() {
        val user: User = User("Pritam", "pritam_224", "prit@gmail.com", "password")

        every { userRepository.save(user) } returns user
        val result = userService.createNewUser(user)

        assertEquals(result, user)
    }

    @Test
    internal fun `should return all the users`() {
        val users: List<List<String>> = listOf(listOf("Pritam", "pritam_224", "prit@gmail.com"),
                            listOf("Pritam2", "pritam_223", "prit3@gmail.com"))
        every { userRepository.findAllUsers() } returns users

        val result = userService.getUsers();

        assertEquals(result, users);

    }
}