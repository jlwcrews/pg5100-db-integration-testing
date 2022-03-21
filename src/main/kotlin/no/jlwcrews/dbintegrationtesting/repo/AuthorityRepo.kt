package no.jlwcrews.dbintegrationtesting.repo

import no.jlwcrews.dbintegrationtesting.entity.AuthorityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorityRepo: JpaRepository<AuthorityEntity, Long> {

    fun findByName(name: String): AuthorityEntity
}