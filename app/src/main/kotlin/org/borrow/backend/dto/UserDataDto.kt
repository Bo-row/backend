package org.borrow.backend.dto

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class UserDataDto(
        override val firstName: String,
        override val lastName: String,
        override val email: String,
        override val password: String,
        override val phoneNumber: Int? = null,
        override val avatar: String? = null
): UserData