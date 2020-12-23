package org.borrow.backend.service

interface PasswordService {
    fun encrypt(password: String): String
    fun verifyPassword(passwordToCheck: String, encodedPassword: String): Boolean
}