package com.jpn.eaglejump.models

import com.jpn.eaglejump.extensions.toUser
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
data class User(val id: String, val userName: String, val password: String)

@Serializable
data class UserInput(val id: String, val password: String)

object Users : Table("users") {
    val id = varchar("id", 255)
    val userName = varchar("user_name", 255)
    val password = varchar("password", 255)

    override val primaryKey = PrimaryKey(id)
}

fun authenticate(id: String, password: String): User? = transaction {
    Users
        .select { (Users.id eq id) and (Users.password eq password) }
        .firstOrNull()?.toUser()
}
