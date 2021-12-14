package com.jpn.eaglejump.plugins

import com.jpn.eaglejump.models.Users
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun connectDatabase() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/ktor_http_api_tutorial",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "postgres"
    )
}

fun migrationDatabase() {
    transaction {
        addLogger(StdOutSqlLogger)
        initUsers()
    }
}

private fun initUsers() {
    SchemaUtils.create(Users)
    Users.insertIgnore {
        it[id] = "USER-ID"
        it[userName] = "Jane"
        it[password] = "password"
    }
}
