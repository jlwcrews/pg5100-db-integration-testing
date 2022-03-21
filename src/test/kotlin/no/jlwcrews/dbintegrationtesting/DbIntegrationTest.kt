package no.jlwcrews.dbintegrationtesting

import no.jlwcrews.dbintegrationtesting.service.AuthService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test")
@Import(AuthService::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DbIntegrationTest {

    @Autowired
    lateinit var authService: AuthService

    @Test
    fun shouldCreateUser(){
        authService.registerUser("ted@tedbear.com", "pirate")
        val createdUser = authService.getUserByEmail("ted@tedbear.com")
        assert(createdUser?.email == "ted@tedbear.com")
        assert(createdUser?.password == "pirate")
    }
}