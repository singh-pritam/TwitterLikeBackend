package com.thoughtworks.twitterlikebackend.controller

import com.thoughtworks.twitterlikebackend.dto.LoginDto
import com.thoughtworks.twitterlikebackend.entity.User
import com.thoughtworks.twitterlikebackend.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("api")
class AuthController(private val userService: UserService) {

    @PostMapping("/login")
    fun login(@RequestBody loginBody: LoginDto, response: HttpServletResponse): ResponseEntity<String> {
        val user: User = userService.getUserByUserName(loginBody.userName);

        if(!user.compare(loginBody.password))
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password")

        val issuer = user.id.toString()
        val jwt = Jwts.builder()
                .setIssuer(issuer)
                .setExpiration(Date(System.currentTimeMillis() + 60*24*1000))
                .signWith(SignatureAlgorithm.HS512, "pritam").compact()  //userIdEncoded

        val cookie= javax.servlet.http.Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity.ok("success")
    }

    @GetMapping("user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {
            try{
                if(jwt == null){
                    throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated")
                }
                val body = Jwts.parser().setSigningKey("pritam").parseClaimsJws(jwt).body

                return ResponseEntity.ok(this.userService.getUserById(body.issuer.toLong()))
            }catch (e: Exception){
                throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated")
            }
    }

    @PostMapping("/logout")
    fun logout(response: HttpServletResponse){
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0

        response.addCookie(cookie)
    }
}