package com.jpn.eaglejump.models

import kotlinx.serialization.Serializable

@Serializable
data class User(val id: String, val userName: String, val password: String)

@Serializable
data class UserInput(val id: String, val password: String)

val userStorage = mutableListOf<User>(User("USER-ID", "Jane", "password"))