package com.jpn.eaglejump

import com.example.plugins.configureSerialization
import com.jpn.eaglejump.plugins.configureSecurity
import com.jpn.eaglejump.routes.setCustomerRoutes
import com.jpn.eaglejump.routes.setDefaultRoutes
import com.jpn.eaglejump.routes.setLoginRoutes
import com.jpn.eaglejump.routes.setOrderRoutes
import io.ktor.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    // install plugins
    configureSerialization()
    configureSecurity()

    // set routing
    setLoginRoutes(environment)
    setDefaultRoutes()
    setCustomerRoutes()
    setOrderRoutes()
}