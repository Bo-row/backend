package org.borrow.backend.resources

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.borrow.backend.domain.User
import org.borrow.backend.dto.UserAuthDto
import org.borrow.backend.repository.UserRepository
import org.borrow.backend.service.PasswordService
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.*
import javax.inject.Inject

@QuarkusTest
@Tag("integrationTest")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoginResourceTest {

    @Inject
    private lateinit var passwordService: PasswordService

    @Inject
    private lateinit var userRepository: UserRepository

    @BeforeAll
    fun setup() {
        userRepository.deleteAll()
        prepareUser()
    }

    @Test
    @DisplayName("It tries to login with existing user email and password")
    fun testLoginOkEndpoint() {
        val result = given()
                .contentType(ContentType.JSON)
                .body(UserAuthDto("test@test.com", "test"))
                .put("/login")
        .then()
                .extract()
                .asString()
        assertThat(result, notNullValue())
    }

    @Test
    @DisplayName("It tries to login with not existing user email and password")
    fun testLoginFailedEndpoint() {
        given()
                .contentType(ContentType.JSON)
                .body(UserAuthDto("test@test.com", "badpass"))
                .put("/login")
        .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
    }

    private fun prepareUser() {
        val user = User(
                firstName = "joe",
                lastName = "doe",
                email = "test@test.com",
                password = passwordService.encrypt("test"),
                avatar = null,
                phoneNumber = null
        )
        user.persist()
    }
}