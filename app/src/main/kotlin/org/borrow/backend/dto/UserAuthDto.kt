package org.borrow.backend.dto

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class UserAuthDto (
    override val email: String,
    override val password: String
): UserAuthData