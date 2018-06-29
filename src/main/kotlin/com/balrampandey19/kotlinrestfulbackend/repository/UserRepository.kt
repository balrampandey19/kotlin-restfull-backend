package com.balrampandey19.kotlinrestfulbackend.repository

import com.balrampandey19.kotlinrestfulbackend.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User, Long>