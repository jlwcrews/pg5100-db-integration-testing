package no.jlwcrews.dbintegrationtesting.controller

import no.jlwcrews.dbintegrationtesting.entity.AuthorityEntity
import no.jlwcrews.dbintegrationtesting.entity.UserEntity
import no.jlwcrews.dbintegrationtesting.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthController(@Autowired private val authService: AuthService) {

    @GetMapping("/user/all")
    fun getUsers(): ResponseEntity<List<UserEntity>>{
        return ResponseEntity.ok().body(authService.getUsers())
    }

    @GetMapping("/authority/all")
    fun getAuthorities(): ResponseEntity<List<AuthorityEntity>>{
        return ResponseEntity.ok().body(authService.getAuthorities())
    }
}