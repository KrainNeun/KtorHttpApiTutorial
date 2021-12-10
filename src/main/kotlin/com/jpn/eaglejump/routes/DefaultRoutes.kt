package com.jpn.eaglejump.routes

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.setDefaultRoutes() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        authenticate("auth-jwt") {
            get("/hello") {
                val principal = call.principal<JWTPrincipal>()
                val username = principal!!.payload.getClaim("username").asString()
                val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())
                call.respondText("Hello, $username! Token is expired at $expiresAt ms.")
            }
        }
    }
}