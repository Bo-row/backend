package org.borrow.backend.service.impl

import org.borrow.backend.service.PasswordService
import org.eclipse.microprofile.config.inject.ConfigProperty
import java.math.BigInteger
import java.security.MessageDigest
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SHA512PasswordService: PasswordService {
    companion object {
        private const val HASH_TEXT_REQUIRED_LENGTH = 32
    }

    @ConfigProperty(name = "backend.password.salt")
    private var salt: String = ""
    private val md: MessageDigest = MessageDigest.getInstance("SHA-512")

    init {
        md.update(salt.toByteArray())
    }

    override fun encrypt(password: String): String {
        val messageDigest = md.digest(password.toByteArray())
        val no = BigInteger(1, messageDigest)
        var hashText: String = no.toString(16)
        if (hashText.length < HASH_TEXT_REQUIRED_LENGTH) {
            val zerosLength = HASH_TEXT_REQUIRED_LENGTH - hashText.length
            return "0".repeat(zerosLength).plus(hashText)
        }
        return hashText
    }

    override fun verifyPassword(passwordToCheck: String, encodedPassword: String): Boolean {
        val encodedPasswordToCheck = encrypt(passwordToCheck)

        return encodedPasswordToCheck == encodedPassword
    }
}