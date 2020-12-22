package org.borrow.backend.repository

import io.quarkus.mongodb.panache.PanacheMongoRepository
import org.borrow.backend.domain.User
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository : PanacheMongoRepository<User> {
    fun findByEmail(email: String): User? {
        return find("email", email).firstResult()
    }
}