package no.jlwcrews.dbintegrationtesting.service

import no.jlwcrews.dbintegrationtesting.entity.AuthorityEntity
import no.jlwcrews.dbintegrationtesting.entity.UserEntity
import no.jlwcrews.dbintegrationtesting.repo.AuthorityRepo
import no.jlwcrews.dbintegrationtesting.repo.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthService(@Autowired private val userRepo: UserRepo, @Autowired private val authorityRepo: AuthorityRepo) {

    fun registerUser(email: String, password: String): UserEntity {
        return userRepo.save(UserEntity(email = email, password = password))
    }

    fun createAuthority(authorityName: String): AuthorityEntity {
        return authorityRepo.save(AuthorityEntity(name = authorityName))
    }

    fun grantAuthorityToUser(email: String, authorityName: String): UserEntity {
        val user = userRepo.findByEmail(email)
        val authority = authorityRepo.findByName(authorityName)
        user.authorities.add(authority)
        return userRepo.save(user)
    }

    fun getUsers(): List<UserEntity>{
        return userRepo.findAll()
    }

    fun getUserByEmail(email: String): UserEntity? {
        return userRepo.findByEmail(email)
    }

    fun getAuthorities(): List<AuthorityEntity>{
        return authorityRepo.findAll()
    }
}