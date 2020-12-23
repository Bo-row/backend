package org.borrow.backend.service.impl

import org.borrow.backend.domain.User
import org.borrow.backend.dto.UserAuthData
import org.borrow.backend.dto.UserDataDto
import org.borrow.backend.dto.UserDto
import org.borrow.backend.dto.extensions.toUserDto
import org.borrow.backend.repository.UserRepository
import org.borrow.backend.service.PasswordService
import java.math.BigInteger
import java.security.MessageDigest
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserService(
        private val userRepository: UserRepository,
        private val passwordService: PasswordService) {
    fun addUser(userDataDto: UserDataDto): UserDto {

        val user = userDataDto.let { User(
                firstName = it.firstName,
                lastName = it.lastName,
                email = it.email,
                password = passwordService.encrypt(it.password),
                phoneNumber = it.phoneNumber,
                avatar = it.avatar
        ) }
        user.persist()

        return user.toUserDto()
    }

    fun verifyUser(userAuthData: UserAuthData): Boolean {
        return userRepository.findByEmail(userAuthData.email)?.let {
            passwordService.verifyPassword(userAuthData.password, it.password)
        } ?: run {
            false
        }
    }

}