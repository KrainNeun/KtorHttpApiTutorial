package com.jpn.eaglejump.routes

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.jpn.eaglejump.models.UserInput
import com.jpn.eaglejump.models.userStorage
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*

fun Route.loginRouting(environment: ApplicationEnvironment) {

    route("/login") {
        post {
            val secret = environment.config.property("jwt.secret").getString()
            val issuer = environment.config.property("jwt.issuer").getString()
            val audience = environment.config.property("jwt.audience").getString()
            val userInput = call.receive<UserInput>()
            val user = userStorage.find { it.id == userInput.id && it.password == userInput.password }
                ?: return@post call.respondText(
                    "user or password is not valid", status = HttpStatusCode.BadRequest
                )
            val token = JWT.create()
                .withAudience(audience)
                .withIssuer(issuer)
                .withClaim("username", user.userName)
                .withExpiresAt(Date(System.currentTimeMillis() + 60000))
                .sign(Algorithm.HMAC256(secret))

            call.respond(hashMapOf("token" to token))
        }
    }
}

fun Application.setLoginRoutes(environment: ApplicationEnvironment) {
    routing {
        loginRouting(environment)
    }
}