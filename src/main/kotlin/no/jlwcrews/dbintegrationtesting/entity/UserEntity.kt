package no.jlwcrews.dbintegrationtesting.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_user_id_seq")
    @SequenceGenerator(
        name = "users_user_id_seq",
        sequenceName = "users_user_id_seq",
        allocationSize = 1
    )
    @Column(name = "user_id")
    val id: Long? = null,

    @Column(name = "user_email")
    val email: String,

    @Column(name = "user_password")
    val password: String,

    @Column(name = "user_enabled")
    val enabled: Boolean? = true,

    @Column(name = "user_created")
    val created: LocalDateTime? = LocalDateTime.now()
) {
    @ManyToMany(fetch = FetchType.EAGER)
    val authorities: MutableList<AuthorityEntity> = mutableListOf()

    override fun toString(): String {
        return "UserEntity(id=$id, email='$email', password='$password', enabled=$enabled, created=$created, authorities=$authorities)"
    }
}