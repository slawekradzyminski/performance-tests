package com.awesome.testing.core

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object HttpConfig {

  val httpProtocol: HttpProtocolBuilder =
    http
      .baseUrl("http://localhost:4000")
      .header("Accept", "application/json")
      .header("Content-Type", "application/json")

}
