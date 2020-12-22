package org.borrow.backend.resources

import org.borrow.backend.dto.UserAuthDto
import org.borrow.backend.service.impl.TokenService
import org.borrow.backend.service.impl.UserService
import javax.annotation.security.PermitAll
import javax.enterprise.context.RequestScoped
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

/**
 * Endpoint responsible for user authentication.
 */
@Path("/login")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class LoginResource(
        private val userService: UserService,
        private val tokenService: TokenService) {

    @PUT
    @PermitAll
    fun login(userAuthDto: UserAuthDto): Response {
        if (userService.verifyUser(userAuthDto)) {
            return Response
                    .ok(tokenService.generateUserToken(userAuthDto.email))
                    .build()
        }
        return Response
                .status(Response.Status.BAD_REQUEST)
                .build()
    }
}