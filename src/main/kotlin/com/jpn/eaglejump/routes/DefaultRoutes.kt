package com.jpn.eaglejump.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.setDefaultRoutes() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}