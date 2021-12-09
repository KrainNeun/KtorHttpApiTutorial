package com.jpn.eaglejump

import com.jpn.eaglejump.routes.setCustomerRoutes
import com.jpn.eaglejump.routes.setDefaultRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json()
        }
        setDefaultRoutes()
        setCustomerRoutes()
    }.start(wait = true)
}