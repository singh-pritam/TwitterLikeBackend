package com.thoughtworks.twitterlikebackend.controller

import com.thoughtworks.twitterlikebackend.model.User
import com.thoughtworks.twitterlikebackend.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(private val userService: UserService) {
    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long) = ResponseEntity.ok(userService.getUserById(userId))

    @PostMapping("/createUser")
    fun createUser(@RequestBody user: User) = ResponseEntity.ok(userService.createNewUser(user))

    @GetMapping("/all")
    fun getAllUsers() = userService.getUsers();
}