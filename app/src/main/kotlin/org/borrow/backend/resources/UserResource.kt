package org.borrow.backend.resources

import org.borrow.backend.dto.UserDataDto
import org.borrow.backend.service.impl.UserService
import javax.annotation.security.PermitAll
import javax.enterprise.context.RequestScoped
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/users")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserResource(private val userService: UserService) {

    @POST
    @PermitAll
    fun addUser(userDataDto: UserDataDto): Response {
        return Response
                .status(Response.Status.CREATED)
                .entity(userService.addUser(userDataDto))
                .build()
    }
}