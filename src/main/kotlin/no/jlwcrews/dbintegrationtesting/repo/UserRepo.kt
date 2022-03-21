package no.jlwcrews.dbintegrationtesting.repo

import no.jlwcrews.dbintegrationtesting.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo: JpaRepository<UserEntity, Long> {

    fun findByEmail(email: String): UserEntity
}