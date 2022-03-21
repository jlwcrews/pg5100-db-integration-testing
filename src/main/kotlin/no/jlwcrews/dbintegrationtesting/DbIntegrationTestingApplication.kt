package no.jlwcrews.dbintegrationtesting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DbIntegrationTestingApplication

fun main(args: Array<String>) {
	runApplication<DbIntegrationTestingApplication>(*args)
}
