@file:JvmName("Server")

package com.github.healthweb.server

import com.typesafe.config.ConfigFactory
import io.ktor.application.Application
import io.ktor.config.HoconApplicationConfig
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import com.github.healthweb.server.config.install
import com.github.healthweb.server.config.root

fun main(args: Array<String>) {
    val conf = HoconApplicationConfig(ConfigFactory.load())
    val port = conf.config("ktor.deployment").property("port").getString().toInt()
    embeddedServer(Netty, port = port, module = Application::mainModule).start(wait = true)
}

fun Application.mainModule() {
    install()
    routing {
        route("/") {
            root()
        }
    }
}

