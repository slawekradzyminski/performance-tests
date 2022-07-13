package com.awesome.testing.config

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object HttpConfig {

  private final val json = "application/json"

  val httpConfig: HttpProtocolBuilder = http
    .baseUrl(LocalConfig.BaseUrl)
    .header("Accept", json)
    .header("Content-Type", json)

}
