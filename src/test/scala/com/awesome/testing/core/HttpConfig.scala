package com.awesome.testing.core

import com.awesome.testing.config.LocalConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object HttpConfig {

  private final val json = "application/json"

  val httpProtocol: HttpProtocolBuilder =
    http
      .baseUrl(LocalConfig.BaseUrl)
      .header("Accept", json)
      .header("Content-Type", json)

}
