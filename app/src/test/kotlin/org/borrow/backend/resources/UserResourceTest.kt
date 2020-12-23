package org.borrow.backend.resources

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.borrow.backend.dto.UserDataDto
import org.borrow.backend.repository.UserRepository
import org.borrow.backend.service.PasswordService
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import javax.inject.Inject

@QuarkusTest
@Tag("integrationTest")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserResourceTest {

    @Inject
    private lateinit var userRepository: UserRepository

    @BeforeAll
    fun setup() {
        userRepository.deleteAll()
    }

    @Test
    fun testRegisterUserEndpoint() {
        given()
            .contentType(ContentType.JSON)
            .body(UserDataDto("joe", "doe", "test@test.com", "pass", 111111111, "url"))
            .post("/users")
        .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("firstName", `is`("joe"))
            .body("lastName", `is`("doe"))
    }
}