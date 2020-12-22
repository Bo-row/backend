package org.borrow.backend.service.impl

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SHA512PasswordServiceTest {
    companion object {
        const val TEST_WORD_HASH = "ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff"
    }
    private val shA512PasswordService = SHA512PasswordService()

    @Test
    @DisplayName("Checks if text was encrypted successfully")
    fun encrypt_successful() {
        assertThat(shA512PasswordService.encrypt("test"), equalTo(TEST_WORD_HASH))
    }

    @Test
    @DisplayName("Checks if text has different value than hash")
    fun encrypt_encrypts_different_values() {
        assertThat(shA512PasswordService.encrypt("pass"), not(equalTo(TEST_WORD_HASH)))
    }

    @Test
    @DisplayName("Passwords should be equal")
    fun verifyPassword_passwords_the_same() {
        assertThat(shA512PasswordService.verifyPassword("test", TEST_WORD_HASH), `is`(true))
    }

    @Test
    @DisplayName("Passwords should be not equal")
    fun verifyPassword_passwords_different() {
        assertThat(shA512PasswordService.verifyPassword("pass", TEST_WORD_HASH), `is`(false))
    }
}