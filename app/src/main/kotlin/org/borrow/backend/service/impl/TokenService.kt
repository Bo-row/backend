package org.borrow.backend.service.impl

import io.smallrye.jwt.build.Jwt
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TokenService {
    @ConfigProperty(name = "mp.jwt.verify.issuer")
    private var issuer: String = ""

    fun generateUserToken(email: String): String {
        return generateToken(email, setOf("User"))
    }

    private fun generateToken(email: String, groups: Set<String>): String {
        return Jwt.issuer(issuer)
                .upn(email)
                .groups(groups)
                .sign()
    }
}