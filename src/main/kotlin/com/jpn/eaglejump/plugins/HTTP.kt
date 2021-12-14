package com.jpn.eaglejump.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*

fun Application.configureHTTP() {
    install(CORS) {
        host("0.0.0.0:5000")
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.ContentType)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
    }
}
