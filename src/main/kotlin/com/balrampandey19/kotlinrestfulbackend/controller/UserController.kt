package com.balrampandey19.kotlinrestfulbackend.controller

import com.balrampandey19.kotlinrestfulbackend.repository.UserRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class UserController(private val userRepository: UserRepository) {
}