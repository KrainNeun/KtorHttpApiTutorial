package com.jpn.eaglejump

import com.jpn.eaglejump.routes.setCustomerRoutes
import com.jpn.eaglejump.routes.setDefaultRoutes
import com.jpn.eaglejump.routes.setOrderRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        json()
    }
    setDefaultRoutes()
    setCustomerRoutes()
    setOrderRoutes()
}