package com.balrampandey19.kotlinrestfulbackend.controller

import com.balrampandey19.kotlinrestfulbackend.model.User
import com.balrampandey19.kotlinrestfulbackend.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class UserController(private val userRepository: UserRepository) {


    @GetMapping("/user")
    fun getAllUser(): List<User> =
            userRepository.findAll()

    @PostMapping("/user")
    fun createNewUser(@Valid @RequestBody user: User): User =
            userRepository.save(user)

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<User> {
        return userRepository.findById(userId).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("/user/{id}")
    fun updateUserById(@PathVariable(value = "id") articleId: Long,
                       @Valid @RequestBody newData: User): ResponseEntity<User> {

        return userRepository.findById(articleId).map { oldData ->
            val updatedUSer: User = oldData
                    .copy(name = newData.name, email = newData.email, password = newData.password)
            ResponseEntity.ok().body(userRepository.save(updatedUSer))
        }.orElse(ResponseEntity.notFound().build())

    }

}