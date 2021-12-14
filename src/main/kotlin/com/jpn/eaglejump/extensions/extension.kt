package com.jpn.eaglejump.extensions

import com.jpn.eaglejump.models.User
import com.jpn.eaglejump.models.Users
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toUser(): User {
    return User(this[Users.id], this[Users.userName], this[Users.password])
}