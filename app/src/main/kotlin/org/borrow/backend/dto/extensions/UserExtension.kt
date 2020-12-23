package org.borrow.backend.dto.extensions

import org.borrow.backend.domain.User
import org.borrow.backend.dto.UserDataDto
import org.borrow.backend.dto.UserDto

fun User.toUserDto() = UserDto(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        password = password,
        phoneNumber = phoneNumber,
        avatar = avatar
)

fun UserDataDto.toUser() = User(
        firstName = firstName,
        lastName = lastName,
        email = email,
        password = password,
        phoneNumber = phoneNumber,
        avatar = avatar
)